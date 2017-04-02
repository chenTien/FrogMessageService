package common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("程序对Spring所做的BeanFactory的初始化没有改变...");
        System.out.println("Spring容器是：" + beanFactory);
    }

}