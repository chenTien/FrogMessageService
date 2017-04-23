package com.jms;

import com.tutorialspoint.Student;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by chen.Tian on 2017/4/6.
 */
public class StudentMDP implements MessageListener{
    @Override
    public void onMessage(Message message) {
        MapMessage mapMessage = (MapMessage) message;
        Student student = new Student();
        try {
            student.setName(mapMessage.getString("key1"));
            student.setAge(mapMessage.getInt("key2"));
            System.out.println(student);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
