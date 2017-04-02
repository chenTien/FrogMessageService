package common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("�����Spring������BeanFactory�ĳ�ʼ��û�иı�...");
        System.out.println("Spring�����ǣ�" + beanFactory);
    }

}