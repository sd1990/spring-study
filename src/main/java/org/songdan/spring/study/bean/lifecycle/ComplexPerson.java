package org.songdan.spring.study.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * 复合型的Person类，此Person实现了多种Spring接口
 * Created by SongDan on 2017/3/23.
 */
public class ComplexPerson implements BeanNameAware,BeanFactoryAware,InitializingBean{

    private String name;

    public ComplexPerson() {
        System.out.println("complex person调用构造函数,name的值是："+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("属性name注入，值为：" + name);
        this.name = name;
    }

    public void initMethod() {
        System.out.println("person init method run ...");
        System.out.println("complex person name is: "+name);
    }

    public void destroyMethod() {
        System.out.println("person destroy method run ...");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("person bean in context name is " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("complex person insject beanfactory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializing bean's afterPropertiesSet Method run ...");
    }
}
