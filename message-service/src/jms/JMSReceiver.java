package com.jms;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.MapMessage;

/**
 * Created by chen.Tian on 2017/4/6.
 */
public class JMSReceiver {
    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void receive() {
        MapMessage mapMessage = (MapMessage) this.getJmsTemplate().receive();
        try {
            if (mapMessage != null) {
                System.out.println(mapMessage.getString("key1") + mapMessage.getInt("key2"));
            } else {
                System.out.println("Î´ÊÕµ½ÄÚÈÝ");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
