package translator;

import org.dom4j.io.SAXReader;

import java.io.*;
import java.text.MessageFormat;

/**
 * Xml�ļ���ʽ��Json�ļ���ʽת����
 * Created by chen.Tian on 2017/4/23.
 */
public class Xml2JsonTranslator implements FileTranslator {
    /**
     * ��XML�ļ���ʽת����JSON�ļ���ʽ
     *
     * @param sourceFileName Դ�ļ���
     * @param targetFileName Ŀ���ļ���
     * @param format         ��Ϣ��ʽ����
     */
    @Override
    public void translate(String sourceFileName, String targetFileName, MessageFormat format) {
        Xml2JsonElementHandler handler = null;
        OutputStreamWriter writer = null;
        try {
            //����json�ļ�����
            File jsonFile = new File(targetFileName);
            //����xml�ļ�����
            File xmlFile = new File(sourceFileName);
            //��װXML�ļ�������
            InputStream input = new FileInputStream(xmlFile);

            OutputStream output = new FileOutputStream(jsonFile);
            writer = new OutputStreamWriter(output,"UTF8");
            //��json��ʼ��ǩд��json�ļ�
            writer.write("[");
            //����XML�¼�������
            handler = new Xml2JsonElementHandler(writer,format);
            //�����ļ���ȡ��
            SAXReader reader = new SAXReader();
            //���ö�ȡ�ַ�����
            reader.setEncoding("UTF8");
            //Ϊ��ȡ�������¼�������,���ƶ�����·��"/Document/Record"
            reader.addHandler("/Document/Record",handler);
            reader.read(input);
            //��ȡ�ļ���β��¼
            String endLine = handler.getRecordBuffer().toString();
            //�����β�Զ��Ž���,ɾ������
            char symbol = endLine.charAt(endLine.length() -1);
            if (symbol==','){
                endLine = endLine.substring(0,endLine.length()-1);
            }
            //д����β��¼
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
