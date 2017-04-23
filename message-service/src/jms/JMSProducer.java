package com.jms;

import com.tutorialspoint.Student;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by chen.Tian on 2017/4/6.
 */
public class JMSProducer {
    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    //传送一个Student对象，重写toString()方法
    public void send(final Student student){
        this.jmsTemplate.send(
                new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        MapMessage mapMessage = session.createMapMessage();
                        mapMessage.setString("key1",student.getName());
                        mapMessage.setInt("key2",student.getAge());
                        return mapMessage;
                    }
                }
        );
    }
}
