package translator;

import java.io.Serializable;

/**
 * 域映射类
 * 
 * @author Administrator
 * @since 2013-07-05
 * @version 1.0
 */
public class FieldMapping extends BaseModel implements Serializable {

	// 序列化版本
	private static final long serialVersionUID = 5292871886822938664L;

	// 消息域标识符
	private String fieldSymbol;

	// XML节点名称
	private String xmlElementName;

	// 是否XML属性
	private boolean xmlAttribute = false;

	// JSON标签名称
	private String jsonTagName;

	// JAVA对象属性名称
	private String javaFieldName;

	// JAVA对象类名
	private String javaClassName;

	// FML32 域标识符
	@Deprecated
	private int fml32FieldId;

	// FML32 域标识符
	private String fml32FieldName;

	// ISO8583域标识符
	private int iso8583FieldId;

	// ISO8583是否是变长
	private boolean iso8583LengthVariable = false;

	// ISO8583固定长度
	private int iso8583FixedLength;

	// ISO8583变长长度
	private int iso8583VariableLength;

	public String getFieldSymbol() {
		return fieldSymbol;
	}

	public String getXmlElementName() {
		return xmlElementName;
	}

	public boolean isXmlAttribute() {
		return xmlAttribute;
	}

	public String getJsonTagName() {
		return jsonTagName;
	}

	public String getJavaFieldName() {
		return javaFieldName;
	}

	public int getFml32FieldId() {
		return fml32FieldId;
	}

	public String getFml32FieldName() {
		return fml32FieldName;
	}

	public int getIso8583FieldId() {
		return iso8583FieldId;
	}

	public boolean isIso8583LengthVariable() {
		return iso8583LengthVariable;
	}

	public int getIso8583FixedLength() {
		return iso8583FixedLength;
	}

	public int getIso8583VariableLength() {
		return iso8583VariableLength;
	}

	public void setFieldSymbol(String fieldSymbol) {
		this.fieldSymbol = fieldSymbol;
	}

	public void setXmlElementName(String xmlElementName) {
		this.xmlElementName = xmlElementName;
	}

	public void setXmlAttribute(boolean xmlAttribute) {
		this.xmlAttribute = xmlAttribute;
	}

	public void setJsonTagName(String jsonTagName) {
		this.jsonTagName = jsonTagName;
	}

	public void setJavaFieldName(String javaFieldName) {
		this.javaFieldName = javaFieldName;
	}

	public void setFml32FieldId(int fml32FieldId) {
		this.fml32FieldId = fml32FieldId;
	}

	public void setFml32FieldName(String fml32FieldName) {
		this.fml32FieldName = fml32FieldName;
	}

	public void setIso8583FieldId(int iso8583FieldId) {
		this.iso8583FieldId = iso8583FieldId;
	}

	public void setIso8583LengthVariable(boolean iso8583LengthVariable) {
		this.iso8583LengthVariable = iso8583LengthVariable;
	}

	public void setIso8583FixedLength(int iso8583FixedLength) {
		this.iso8583FixedLength = iso8583FixedLength;
	}

	public void setIso8583VariableLength(int iso8583VariableLength) {
		this.iso8583VariableLength = iso8583VariableLength;
	}

	public String getJavaClassName() {
		return javaClassName;
	}

	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}

}
