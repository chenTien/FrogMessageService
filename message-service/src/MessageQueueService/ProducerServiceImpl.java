package MessageQueueService;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by chen.Tian on 2017/4/14.
 */
@Component
public class ProducerServiceImpl implements ProducerService{
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(Destination destination, final String messsge) {
        System.out.println("------------生产者发送消息------------");
        System.out.println("-------------生产者发送了一个消息------" + messsge);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(messsge);
            }
        });
    }
    @Resource
    public void setJmsTemplate(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }
    public JmsTemplate getJmsTemplate(){
        return jmsTemplate;
    }
}
