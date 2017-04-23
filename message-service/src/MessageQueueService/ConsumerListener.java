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
        //由于是发送的文本消息,所以可以直接进行转换
        TextMessage textMessage = (TextMessage) message;
        System.out.println("接收到一个纯文本消息: " );
        try {
            System.out.println("消息内容是: " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
