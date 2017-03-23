package org.songdan.spring.study.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by SongDan on 2017/3/23.
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public CustomBeanFactoryPostProcessor() {
        System.out.println("BeanFactoryPostProcessor调用构造方法");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("complexPerson");
        //这个地方会覆盖掉注入的属性
        beanDefinition.getPropertyValues().addPropertyValue("name", "forever");
    }
}
