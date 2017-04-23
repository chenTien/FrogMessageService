package translator;

import org.dom4j.io.SAXReader;

import java.io.*;
import java.text.MessageFormat;

/**
 * Xml文件格式到Json文件格式转换器
 * Created by chen.Tian on 2017/4/23.
 */
public class Xml2JsonTranslator implements FileTranslator {
    /**
     * 从XML文件格式转换到JSON文件格式
     *
     * @param sourceFileName 源文件名
     * @param targetFileName 目标文件名
     * @param format         消息格式定义
     */
    @Override
    public void translate(String sourceFileName, String targetFileName, MessageFormat format) {
        Xml2JsonElementHandler handler = null;
        OutputStreamWriter writer = null;
        try {
            //创建json文件对象
            File jsonFile = new File(targetFileName);
            //创建xml文件对象
            File xmlFile = new File(sourceFileName);
            //封装XML文件输入流
            InputStream input = new FileInputStream(xmlFile);

            OutputStream output = new FileOutputStream(jsonFile);
            writer = new OutputStreamWriter(output,"UTF8");
            //将json开始标签写入json文件
            writer.write("[");
            //创建XML事件触发者
            handler = new Xml2JsonElementHandler(writer,format);
            //创建文件读取者
            SAXReader reader = new SAXReader();
            //设置读取字符编码
            reader.setEncoding("UTF8");
            //为读取者设置事件触发器,并制定触发路径"/Document/Record"
            reader.addHandler("/Document/Record",handler);
            reader.read(input);
            //获取文件行尾记录
            String endLine = handler.getRecordBuffer().toString();
            //如果行尾以逗号结束,删除逗号
            char symbol = endLine.charAt(endLine.length() -1);
            if (symbol==','){
                endLine = endLine.substring(0,endLine.length()-1);
            }
            //写入行尾记录
            writer.write(endLine);
            writer.write("]");
        } catch (Exception e) {
            System.out.println("Doing file translation from flat to xml failed! "+ e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Colse the writer failed! " + e);
            }
        }
    }
}
