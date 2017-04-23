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
    //�ļ�д����
    private OutputStreamWriter writer;
    //��Ϣ��ʽ
    private MessageFormat format;
    //�л���
    private StringBuilder recordBuffer = new StringBuilder();

    //Constructor
    public Xml2JsonElementHandler(OutputStreamWriter writer, MessageFormat format) {
        this.writer = writer;
        this.format = format;
    }

    /**
     * XML��ʼ��ǩ�����¼�����
     *
     * @param elementPath �����¼�·��
     */
    @Override
    public void onStart(ElementPath elementPath) {
        //���������ݲ�Ϊ��,��д�뵽�ļ���,Ȼ����ջ�����
        if (recordBuffer.length() > 0) {
            try {
                writer.write(recordBuffer.toString());
                recordBuffer.delete(0, recordBuffer.length());
                //���JSON�ļ��ָ���
                recordBuffer.append(",");
            } catch (IOException e) {
                System.out.println("Write to json failed " + e);
            }
        }
    }

    /**
     * XML������ǩ����
     *
     * @param elementPath �����¼�·��
     */
    @Override
    public void onEnd(ElementPath elementPath) {
        //��ȡ��ǰ·���ڵ�
        Element row = elementPath.getCurrent();
        //ȡ���ӽڵ���������Ԫ��
        List records = row.elements();
        if (records.size() > 0) {
            //������Ԫ������
            int index = 0;
            //���������
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            //������Ϣ��ʽ�ж����������
            for (MessageField field : format.getMessageFields()) {
                // ��ȡ�����jsonӳ������
                String targetName = field.getFieldMapping().getJsonTagName();
                //��ȡ�������Ӧ��ֵ
                String value = (Element) records.get(index++).getTextTrim();
                //���ݸ��������͵�ֵ���ͽ���ת��,���洢�����������
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
