package common;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public class XmlHelper {
    /**
     *
     * @param document
     * @param charset
     * @return
     */
    public static String toPrettyFormatXml(Document document,String charset){
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding(charset);
        StringWriter buffer = new StringWriter();
        XMLWriter writer = new XMLWriter(buffer,outputFormat);

        try {
            writer.write(document);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    writer = null;
                }
            }
        }
        return null;
    }

    public static String toPrettyFormatXml(Element element,String charset) {
        Document document = DocumentHelper.createDocument(element);
        return toPrettyFormatXml(document,charset);
    }

}
