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
    //报文日志DID
    private long messageLogId;
    //报文ID
    private String messageId;
    //发送者ID
    private String senderId;
    //业务日志ID
    private long businessLogId;
    //版本号
    private String version;
    //系统ID
    private String frogSystemId;
    //服务访问者ID
    private String visitorId;
    //服务访问者流水号
    private String visitorSn;
    //服务提供者ID
    private String providerId;
    //服务提供者流水号
    private String providerSn;
    //服务码
    private String serviceCode;
    //报文编号
    private String messageNo;
    //应该模式
    private String replyMode;
    //消息类型
    private String messageType;
    //发送报文时间
    private Date sendTime;
    //收到报文时间
    private Date receiveTime;
    //分组ID
    private String groupId;
    //分组总数
    private int groupCount;
    //当前分组号
    private int groupIndex;
    //请求附件
    private String attachments;
    //重试次数
    private int retryTimes = 0;
    //最后重试时间
    private Date lastRetryTime;
    //重试标识
    private boolean needRetry;
    //创建时间
    private Date createDate = new Date();
    //最后修改时间
    private Date modifyDate = new Date();
    //管理状态
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
