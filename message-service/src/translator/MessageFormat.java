package translator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen.Tian on 2017/4/23.
 */
public class MessageFormat extends BaseModel implements Serializable {
    // ���л��汾
    private static final long serialVersionUID = 5792438545812772801L;
    //��Ϣ��ʽ��ʶ��
    private String formatId;
    //���ı��
    private String messageNo;
    //��Ϣ��ʽ����
    private String formatName;
    //��Ϣ��ʽ����
    private String formatGroup;
    //��ʾ��
    private String javaClass;
    //xml schema
    private String xmlSchema;
    //��Ϣ���б�
    private List<MessageField> messageFields = new ArrayList<>();

    public String getFormatId() {
        return formatId;
    }

    public void setFormatId(String formatId) {
        this.formatId = formatId;
    }

    public String getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public String getFormatGroup() {
        return formatGroup;
    }

    public void setFormatGroup(String formatGroup) {
        this.formatGroup = formatGroup;
    }

    public String getJavaClass() {
        return javaClass;
    }

    public void setJavaClass(String javaClass) {
        this.javaClass = javaClass;
    }

    public String getXmlSchema() {
        return xmlSchema;
    }

    public void setXmlSchema(String xmlSchema) {
        this.xmlSchema = xmlSchema;
    }

    public List<MessageField> getMessageFields() {
        return messageFields;
    }

    public void setMessageFields(List<MessageField> messageFields) {
        this.messageFields = messageFields;
    }
}
