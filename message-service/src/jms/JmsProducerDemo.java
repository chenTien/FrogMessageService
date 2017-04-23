package com.jms;

import com.tutorialspoint.Student;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * Created by chen.Tian on 2017/4/6.
 */
public class JmsProducerDemo {
    public static void main(String[] args) {
        //ConnectionFactory���ӹ���
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection=null;
        Session session = null;
        try {
            connection= connectionFactory.createConnection();
            session  = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //������ϢĿ�ĵ����ͣ�ActiveMQTopicΪ����Ŀ�ĵ�
            Destination destination = new ActiveMQQueue("myQueue");
            MessageProducer producer = session.createProducer(destination);

            Student student = new Student();
            student.setName("zq");
            student.setAge(25);

            //ʹ����Ϣת��
            StudentMessageConverter studentMessageConverter = new StudentMessageConverter();
            producer.send(studentMessageConverter.toMessage(student,session));
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null){
                    session.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
