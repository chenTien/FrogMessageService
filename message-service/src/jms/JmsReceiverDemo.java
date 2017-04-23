package com.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * Created by chen.Tian on 2017/4/6.
 */
public class JmsReceiverDemo {
    public static void main(String[] args) {
        //产生连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection=null;
        Session session = null;

        try {
            connection= connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //设置消息目的地类型
            Destination destination = new ActiveMQQueue("myQueue");
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            Message message = consumer.receive();
            StudentMessageConverter studentMessageConverter = new StudentMessageConverter();
            System.out.println(studentMessageConverter.fromMessage(message));
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session !=null){
                    session.close();
                }
                if (connection !=null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
