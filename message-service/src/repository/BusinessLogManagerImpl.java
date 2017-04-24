package bizlogAndMsgLog;

import java.util.List;

/**
 * Created by chen.Tian on 2017/4/24.
 */
public class BusinessLogManagerImpl implements BusinessLogManager {
    @Override
    public void writeBusinessLog(BusinessLog businessLog) {

    }

    @Override
    public void updateBusinessLog(BusinessLog businessLog) {

    }

    @Override
    public void writeBusinessLogContents(BusinessLogContent businessLogContent) {

    }

    @Override
    public void updateBusinessLogResponseContent(long businessLogId, Object responseContent) {

    }

    @Override
    public BusinessLogContent getBusinessLogContent(long businessLogId) {
        return null;
    }

    @Override
    public BusinessLog getBusinessLogByEsbSn(String esbSn) {
        return null;
    }

    @Override
    public BusinessLog getBusinessLogById(long businessLogId) {
        return null;
    }

    @Override
    public BusinessLog getBusinessLogByVisitorSn(String visitorCode, String visitorSn) {
        return null;
    }

    @Override
    public List<BusinessLog> getChildLogsByParentLogId(long parentLogId) {
        return null;
    }

    @Override
    public MessageLog getMessageLog(String messageId, String senderId) {
        return null;
    }

    @Override
    public MessageLog getMessageLog(String senderId, MessageType messageType, long businessLogId) {
        return null;
    }

    @Override
    public MessageLog getMessageLogByGroup(String groupId, String senderId, int groupIndex) {
        return null;
    }

    @Override
    public MessageLog getMessageLogById(String messageLogId) {
        return null;
    }

    @Override
    public void writeMessageLog(MessageLog messageLog) {

    }

    @Override
    public int updateMessageLogBizLogId(String messageId, String senderId, long businessLogId) {
        return 0;
    }

    @Override
    public Pager queryBusinessLogHistory(Pager pager) {
        return null;
    }

    @Override
    public Pager queryMessageLogHistory(Pager pager) {
        return null;
    }
}
