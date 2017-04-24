package bizlogAndMsgLog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by chen.Tian on 2017/4/24.
 */
@Entity
@Table(name = "FROG_MESSAGE_LOG")
public class MessageLog implements Serializable {
    private static final long serialVersionID = 6920423547492142365L;
    //������־DID
    private long messageLogId;
    //����ID
    private String messageId;
    //������ID
    private String senderId;
    //ҵ����־ID
    private long businessLogId;
    //�汾��
    private String version;
    //ϵͳID
    private String frogSystemId;
    //���������ID
    private String visitorId;
    //�����������ˮ��
    private String visitorSn;
    //�����ṩ��ID
    private String providerId;
    //�����ṩ����ˮ��
    private String providerSn;
    //������
    private String serviceCode;
    //���ı��
    private String messageNo;
    //Ӧ��ģʽ
    private String replyMode;
    //��Ϣ����
    private String messageType;
    //���ͱ���ʱ��
    private Date sendTime;
    //�յ�����ʱ��
    private Date receiveTime;
    //����ID
    private String groupId;
    //��������
    private int groupCount;
    //��ǰ�����
    private int groupIndex;
    //���󸽼�
    private String attachments;
    //���Դ���
    private int retryTimes = 0;
    //�������ʱ��
    private Date lastRetryTime;
    //���Ա�ʶ
    private boolean needRetry;
    //����ʱ��
    private Date createDate = new Date();
    //����޸�ʱ��
    private Date modifyDate = new Date();
    //����״̬
    private String manageStatus = "A";

    @Id
    @Column(name = "MESSAGE_LOG_ID")
    public long getMessageLogId() {
        return messageLogId;
    }

    public void setMessageLogId(long messageLogId) {
        this.messageLogId = messageLogId;
    }

    @Column(name = "MESSAGE_ID")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Column(name = "SENDER_ID")
    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Column(name = "BUSINESS_LOG_ID")
    public long getBusinessLogId() {
        return businessLogId;
    }

    public void setBusinessLogId(long businessLogId) {
        this.businessLogId = businessLogId;
    }

    @Column(name = "VERSION")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Column(name = "FROG_SYSTEM_ID")
    public String getFrogSystemId() {
        return frogSystemId;
    }

    public void setFrogSystemId(String frogSystemId) {
        this.frogSystemId = frogSystemId;
    }

    @Column(name = "VISITOR_ID")
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    @Column(name = "VISITOR_SN")
    public String getVisitorSn() {
        return visitorSn;
    }

    public void setVisitorSn(String visitorSn) {
        this.visitorSn = visitorSn;
    }

    @Column(name = "PROVIDER_ID")
    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    @Column(name = "PROVIDER_SN")
    public String getProviderSn() {
        return providerSn;
    }

    public void setProviderSn(String providerSn) {
        this.providerSn = providerSn;
    }

    @Column(name = "SERVICE_CODE")
    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Column(name = "MESSAGE_NO")
    public String getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }

    @Column(name = "REPLY_MODE")
    public String getReplyMode() {
        return replyMode;
    }

    public void setReplyMode(String replyMode) {
        this.replyMode = replyMode;
    }

    @Column(name = "MESSAGE_TYPE")
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Column(name = "SEND_TIME")
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Column(name = "RECEIVE_TIME")
    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Column(name = "GROUP_ID")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(name = "GROUP_COUNT")
    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    @Column(name = "GROUP_INDEX")
    public int getGroupIndex() {
        return groupIndex;
    }

    public void setGroupIndex(int groupIndex) {
        this.groupIndex = groupIndex;
    }

    @Column(name = "ATTACHMENTS")
    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    @Column(name = "RETRY_TIMES")
    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    @Column(name = "LAST_RETRY_TIME")
    public Date getLastRetryTime() {
        return lastRetryTime;
    }

    public void setLastRetryTime(Date lastRetryTime) {
        this.lastRetryTime = lastRetryTime;
    }

    @Column(name = "NEED_RETRY")
    public boolean isNeedRetry() {
        return needRetry;
    }

    public void setNeedRetry(boolean needRetry) {
        this.needRetry = needRetry;
    }

    @Column(name = "CREATE_DATE")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "MODIFY_DATE")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Column(name = "MANAGE_STATUS")
    public String getManageStatus() {
        return manageStatus;
    }

    public void setManageStatus(String manageStatus) {
        this.manageStatus = manageStatus;
    }
}
