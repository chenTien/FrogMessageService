package bizlogAndMsgLog;

import java.util.List;

/**
 * Created by chen.Tian on 2017/4/24.
 */
public interface BusinessLogManager {
    /**
     * дҵ����־
     *
     * @param businessLog
     *            ҵ����־
     */
    void writeBusinessLog(BusinessLog businessLog);

    /**
     * ����ҵ����־����������Ӧ������
     *
     * @param businessLog
     *            ҵ����־
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
     * �����ۺ�ǰ����ˮ��ȡҵ����־
     *
     * @param esbSn
     *            �ۺ�ǰ����ˮ��
     * @return ҵ����־
     */
    BusinessLog getBusinessLogByEsbSn(String esbSn);

    /**
     *
     * @param businessLogId
     * @return
     */
    BusinessLog getBusinessLogById(long businessLogId);

    /**
     * ���ݷ����������ˮ��ȡҵ����־
     *
     * @param visitorCode
     *            ���������ID
     * @param visitorSn
     *            ��ˮ��
     * @return ҵ����־
     */
    BusinessLog getBusinessLogByVisitorSn(String visitorCode, String visitorSn);

    /**
     * �����Ҫ���Եı���
     *
     * @return
     */
//	List<MessageLog> getMessageLogForRetry(Date date);

    /**
     * ȡָ����־������־
     *
     * @param parentLogId
     *            �ۺ�ǰ����ˮ��
     * @return ����־
     */
    List<BusinessLog> getChildLogsByParentLogId(long parentLogId);

    /**
     * ͨ��messageId��senderId����messageLog
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
     * ���ݷ���ź͵�ǰ���л�ñ�����־��û���򷵻�null
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
     * ��¼������־
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
     * ���±���ҵ����־ID
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
