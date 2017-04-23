package translator;

import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by chen.Tian on 2017/4/23.
 */
public class Xml2JsonElementHandler implements ElementHandler {
    //文件写入器
    private OutputStreamWriter writer;
    //消息格式
    private MessageFormat format;
    //行缓冲
    private StringBuilder recordBuffer = new StringBuilder();

    //Constructor
    public Xml2JsonElementHandler(OutputStreamWriter writer, MessageFormat format) {
        this.writer = writer;
        this.format = format;
    }

    /**
     * XML开始标签触发事件方法
     *
     * @param elementPath 触发事件路径
     */
    @Override
    public void onStart(ElementPath elementPath) {
        //缓冲区数据不为空,则写入到文件中,然后清空缓冲区
        if (recordBuffer.length() > 0) {
            try {
                writer.write(recordBuffer.toString());
                recordBuffer.delete(0, recordBuffer.length());
                //添加JSON文件分隔符
                recordBuffer.append(",");
            } catch (IOException e) {
                System.out.println("Write to json failed " + e);
            }
        }
    }

    /**
     * XML结束标签触发
     *
     * @param elementPath 触发事件路径
     */
    @Override
    public void onEnd(ElementPath elementPath) {
        //获取当前路径节点
        Element row = elementPath.getCurrent();
        //取出子节点下所有子元素
        List records = row.elements();
        if (records.size() > 0) {
            //定义子元素索引
            int index = 0;
            //结果缓冲区
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            //遍历消息格式中定义的所有域
            for (MessageField field : format.getMessageFields()) {
                // 获取该域的json映射域名
                String targetName = field.getFieldMapping().getJsonTagName();
                //获取该域相对应的值
                String value = (Element) records.get(index++).getTextTrim();
                //根据该域定义类型的值类型进行转换,并存储结果到缓冲区
                map.put(targetName, Long.parseLong(value));
            }
        }
    }

    public OutputStreamWriter getWriter() {
        return writer;
    }

    public void setWriter(OutputStreamWriter writer) {
        this.writer = writer;
    }

    public MessageFormat getFormat() {
        return format;
    }

    public void setFormat(MessageFormat format) {
        this.format = format;
    }

    public StringBuilder getRecordBuffer() {
        return recordBuffer;
    }

    public void setRecordBuffer(StringBuilder recordBuffer) {
        this.recordBuffer = recordBuffer;
    }
}
