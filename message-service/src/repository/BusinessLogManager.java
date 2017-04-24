package bizlogAndMsgLog;

import java.util.List;

/**
 * Created by chen.Tian on 2017/4/24.
 */
public interface BusinessLogManager {
    /**
     * 写业务日志
     *
     * @param businessLog
     *            业务日志
     */
    void writeBusinessLog(BusinessLog businessLog);

    /**
     * 更新业务日志，更新请求应答内容
     *
     * @param businessLog
     *            业务日志
     */
    void updateBusinessLog(BusinessLog businessLog);

    /**
     *
     * @param businessLogContent
     */
    void writeBusinessLogContents(BusinessLogContent businessLogContent);


    /**
     *
     * @param businessLogId
     * @param responseContent
     */
    void updateBusinessLogResponseContent(long businessLogId,Object responseContent);

    /**
     *
     * @param businessLogId
     * @return
     */
    BusinessLogContent getBusinessLogContent(long businessLogId);

    /**
     * 根据综合前置流水号取业务日志
     *
     * @param esbSn
     *            综合前置流水号
     * @return 业务日志
     */
    BusinessLog getBusinessLogByEsbSn(String esbSn);

    /**
     *
     * @param businessLogId
     * @return
     */
    BusinessLog getBusinessLogById(long businessLogId);

    /**
     * 根据服务访问者流水号取业务日志
     *
     * @param visitorCode
     *            服务访问者ID
     * @param visitorSn
     *            流水号
     * @return 业务日志
     */
    BusinessLog getBusinessLogByVisitorSn(String visitorCode, String visitorSn);

    /**
     * 获得需要重试的报文
     *
     * @return
     */
//	List<MessageLog> getMessageLogForRetry(Date date);

    /**
     * 取指定日志的子日志
     *
     * @param parentLogId
     *            综合前置流水号
     * @return 子日志
     */
    List<BusinessLog> getChildLogsByParentLogId(long parentLogId);

    /**
     * 通过messageId和senderId查找messageLog
     *
     * @param messageId
     * @param senderId
     * @return
     */
    MessageLog getMessageLog(String messageId, String senderId);

    /**
     *
     * @param senderId
     * @param messageType
     * @param businessLogId
     * @return
     */
    MessageLog getMessageLog(String senderId, MessageType messageType, long businessLogId);

    /**
     * 根据分组号和当前序列获得报文日志，没有则返回null
     *
     * @param groupId
     * @param senderId
     * @param groupIndex
     * @return
     */
    MessageLog getMessageLogByGroup(String groupId, String senderId, int groupIndex);

    /**
     *
     * @param messageLogId
     * @return
     */
    MessageLog getMessageLogById(String messageLogId);

    /**
     * 记录报文日志
     *
     * @param messageLog
     */
    void writeMessageLog(MessageLog messageLog);

    /**
     *
     * @param messageLog
     * @param needRetry
     * @param retryTimes
     * @param date
     * @return
     */
//	int updateMessageLogRetry(MessageLog messageLog,boolean needRetry,int retryTimes,Date date);

    /**
     * 更新报文业务日志ID
     *
     * @param messageId
     * @param senderId
     * @param businessLogId
     */
    int updateMessageLogBizLogId(String messageId, String senderId, long businessLogId);

    /**
     *
     * @param pager
     * @return
     */
    Pager queryBusinessLogHistory(Pager pager);

    /**
     *
     * @param pager
     * @return
     */
    Pager queryMessageLogHistory(Pager pager);


    //List<MessageLog> getMessageLogByCondition(String senderId, long businessLogId);

}
