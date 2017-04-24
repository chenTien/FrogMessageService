package adbc.esb.bizlog;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "FROG_BUSINESS_LOG")
public class BusinessLog implements Serializable {

	private static final long serialVersionUID = 6920423547492142365L;

	// 日志号
	private long businessLogId;

	// 父日志号
	private long parentLogId;

	// 系统节点ID
	private String frogSystemId;

	// 系统流水号
	private String frogSystemSn;

	// 服务访问者节点ID
	private String visitorId;

	// 服务访问者渠道号
	private String visitorCode;

	// 服务访问者流水号
	private String visitorSn;

	// 服务提供者节点ID
	private String providerId;

	// 服务访问者渠道号
	private String providerCode;

	// 服务提供者流水号
	private String providerSn;

	// 服务码
	private String serviceCode;

	// 服务类型
	private String serviceType;

	// 服务访问者应答模式
	private String visitorReplyMode;

	// 服务提供者应答模式
	private String providerReplyMode;

	// 工作状态
	private String workStatus;

	// 收到请求时间
	private Date receiveRequestTime;

	// 提交请求时间
	private Date committedRequestTime;

	// 提交完成时间
	private Date committedCompleteTime;

	// 收到应答时间
	private Date receivedResultTime;

	// 通知结果时间
	private Date notifyResultTime;

	// 处理完毕时间
	private Date processFinishedTime;

	// 请求取消时间
	private Date requestCancelledTime;

	// 处理结果
	private String result;
	
	// 分组ID
	private String groupId;

	// 分组总数
	private Integer groupCount;

	// 当前分组号
	private Integer groupIndex;
	
	// 通道名称
	private String serviceChannel;

	// 创建时间
	private Date createDate = new Date();

	// 修改时间
	private Date modifyDate = new Date();

	// 管理状态
	private String manageStatus = "A";

	//请求报文messageid
	private String messageId;
	
	@Id
	@Column(name = "BUSINESS_LOG_ID")
	public long getBusinessLogId() {
		return businessLogId;
	}

	@Column(name = "PARENT_LOG_ID")
	public long getParentLogId() {
		return parentLogId;
	}

	@Column(name = "FROG_SYSTEM_ID")
	public String getEsbId() {
		return esbId;
	}

	@Column(name = "FROG_SYSTEM_SN")
	public String getEsbSn() {
		return esbSn;
	}

	@Column(name = "VISITOR_ID")
	public String getVisitorId() {
		return visitorId;
	}

	@Column(name = "VISITOR_SN")
	public String getVisitorSn() {
		return visitorSn;
	}

	@Column(name = "PROVIDER_ID")
	public String getProviderId() {
		return providerId;
	}

	@Column(name = "PROVIDER_SN")
	public String getProviderSn() {
		return providerSn;
	}

	@Column(name = "SERVICE_CODE")
	public String getServiceCode() {
		return serviceCode;
	}

	@Column(name = "SERVICE_TYPE")
	public String getServiceType() {
		return serviceType;
	}

	@Column(name = "VISITOR_REPLY_MODE")
	public String getVisitorReplyMode() {
		return visitorReplyMode;
	}

	@Column(name = "PROVIDER_REPLY_MODE")
	public String getProviderReplyMode() {
		return providerReplyMode;
	}

	@Column(name = "WORK_STATUS")
	public String getWorkStatus() {
		return workStatus;
	}

	@Column(name = "RECEIVE_REQUEST_TIME")
	public Date getReceiveRequestTime() {
		return receiveRequestTime;
	}

	@Column(name = "COMMITTED_REQUEST_TIME")
	public Date getCommittedRequestTime() {
		return committedRequestTime;
	}

	@Column(name = "COMMITTED_COMPLETE_TIME")
	public Date getCommittedCompleteTime() {
		return committedCompleteTime;
	}

	@Column(name = "RECEIVED_RESULT_TIME")
	public Date getReceivedResultTime() {
		return receivedResultTime;
	}

	@Column(name = "NOTIFY_RESULT_TIME")
	public Date getNotifyResultTime() {
		return notifyResultTime;
	}

	@Column(name = "PROCESS_FINISHED_TIME")
	public Date getProcessFinishedTime() {
		return processFinishedTime;
	}

	@Column(name = "REQUEST_CANCELLED_TIME")
	public Date getRequestCancelledTime() {
		return requestCancelledTime;
	}

	@Column(name = "VISITOR_CODE")
	public String getVisitorCode() {
		return visitorCode;
	}

	@Column(name = "PROVIDER_CODE")
	public String getProviderCode() {
		return providerCode;
	}

	@Column(name = "RESULT")
	public String getResult() {
		return result;
	}
	
	@Column(name = "GROUP_ID")
	public String getGroupId() {
		return groupId;
	}

	@Column(name = "GROUP_COUNT")
	public Integer getGroupCount() {
		return groupCount;
	}

	@Column(name = "GROUP_INDEX")
	public Integer getGroupIndex() {
		return groupIndex;
	}

	@Column(name = "SERVICE_CHANNEL")
	public String getServiceChannel() {
		return serviceChannel;
	}

	@Column(name = "CREATE_DATE", updatable = false)
	public Date getCreateDate() {
		return createDate;
	}

	@Column(name = "MODIFY_DATE")
	public Date getModifyDate() {
		return modifyDate;
	}

	@Column(name = "MANAGE_STATUS")
	public String getManageStatus() {
		return manageStatus;
	}
	
	@Column(name = "MESSAGE_ID")
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public void setBusinessLogId(long businessLogId) {
		this.businessLogId = businessLogId;
	}

	public void setParentLogId(long parentLogId) {
		this.parentLogId = parentLogId;
	}

	public void setEsbId(String esbId) {
		this.esbId = esbId;
	}

	public void setEsbSn(String esbSn) {
		this.esbSn = esbSn;
	}

	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}

	public void setVisitorSn(String visitorSn) {
		this.visitorSn = visitorSn;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public void setProviderSn(String providerSn) {
		this.providerSn = providerSn;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void setVisitorReplyMode(String visitorReplyMode) {
		this.visitorReplyMode = visitorReplyMode;
	}

	public void setProviderReplyMode(String providerReplyMode) {
		this.providerReplyMode = providerReplyMode;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public void setReceiveRequestTime(Date receiveRequestTime) {
		this.receiveRequestTime = receiveRequestTime;
	}

	public void setCommittedRequestTime(Date committedRequestTime) {
		this.committedRequestTime = committedRequestTime;
	}

	public void setCommittedCompleteTime(Date committedCompleteTime) {
		this.committedCompleteTime = committedCompleteTime;
	}

	public void setReceivedResultTime(Date receivedResultTime) {
		this.receivedResultTime = receivedResultTime;
	}

	public void setNotifyResultTime(Date notifyResultTime) {
		this.notifyResultTime = notifyResultTime;
	}

	public void setProcessFinishedTime(Date processFinishedTime) {
		this.processFinishedTime = processFinishedTime;
	}

	public void setRequestCancelledTime(Date requestCancelledTime) {
		this.requestCancelledTime = requestCancelledTime;
	}

	public void setVisitorCode(String visitorCode) {
		this.visitorCode = visitorCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setGroupCount(Integer groupCount) {
		this.groupCount = groupCount;
	}

	public void setGroupIndex(Integer groupIndex) {
		this.groupIndex = groupIndex;
	}

	public void setServiceChannel(String serviceChannel) {
		this.serviceChannel = serviceChannel;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setManageStatus(String manageStatus) {
		this.manageStatus = manageStatus;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
