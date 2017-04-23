package translator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息域类
 *
 * @author Administrator
 * @version 1.0
 * @since 2013-07-05
 */
public class MessageField extends BaseModel implements Serializable {

    // 序列化版本
    private static final long serialVersionUID = -5886734452778580524L;

    private long fieldId;

    private long parentId;

    // 消息域排序序号
    private int fieldIndex;

    // 消息域标识符
    private String fieldSymbol;

    // 消息域名称
    private String fieldName;

    // 消息域描述
    private String fieldDesc;

    // 消息域类型
//    private FieldType fieldType;

    // 消息域映射
    private FieldMapping fieldMapping;

//	// 值校验数据
//	private VerifyData verifyData;

    // 子消息域
    private List<MessageField> subFields = new ArrayList<MessageField>();

    public int getFieldIndex() {
        return fieldIndex;
    }

    public String getFieldSymbol() {
        return fieldSymbol;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

//	public FieldType getFieldType() {
//		return fieldType;
//	}

    public FieldMapping getFieldMapping() {
        return fieldMapping;
    }

//	public VerifyData getVerifyData() {
//		return verifyData;
//	}

    public List<MessageField> getSubFields() {
        return subFields;
    }

    public void setFieldIndex(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    public void setFieldSymbol(String fieldSymbol) {
        this.fieldSymbol = fieldSymbol;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

//	public void setFieldType(FieldType fieldType) {
//		this.fieldType = fieldType;
//	}

    public void setFieldMapping(FieldMapping fieldMapping) {
        this.fieldMapping = fieldMapping;
    }

//	public void setVerifyData(VerifyData verifyData) {
//		this.verifyData = verifyData;
//	}

    public void setSubFields(List<MessageField> subFields) {
        this.subFields = subFields;
    }

    public long getFieldId() {
        return fieldId;
    }

    public void setFieldId(long fieldId) {
        this.fieldId = fieldId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

}
