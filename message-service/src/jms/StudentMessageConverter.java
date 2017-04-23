package com.jms;

import com.tutorialspoint.Student;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by chen.Tian on 2017/4/6.
 */
public class StudentMessageConverter implements MessageConverter{
    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        if (!(o instanceof Student)){
            throw new MessageConversionException("Object is not a Student");
        }
        Student student = (Student) o;
        MapMessage mapMessage = session.createMapMessage();
        mapMessage.setString("key1",student.getName());
        mapMessage.setInt("key2",student.getAge());
        return mapMessage;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        if (!(message instanceof MapMessage)){
            throw new MessageConversionException("Message is not a MapMessage");
        }
        MapMessage mapMessage = (MapMessage) message;
        Student student = new Student();
        student.setName(mapMessage.getString("key1"));
        student.setAge(mapMessage.getInt("key2"));
        return student;
    }
}
