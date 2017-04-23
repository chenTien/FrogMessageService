package MessageQueueService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by chen.Tian on 2017/4/14.
 */
public class ConsumerListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        //�����Ƿ��͵��ı���Ϣ,���Կ���ֱ�ӽ���ת��
        TextMessage textMessage = (TextMessage) message;
        System.out.println("���յ�һ�����ı���Ϣ: " );
        try {
            System.out.println("��Ϣ������: " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
