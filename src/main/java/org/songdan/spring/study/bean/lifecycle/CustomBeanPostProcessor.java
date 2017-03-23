package org.songdan.spring.study.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义的Bean的后置处理器
 * Created by SongDan on 2017/3/23.
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public CustomBeanPostProcessor() {
        System.out.println("BeanPostProcessor调用构造方法");
    }

    /**
     * 在bean初始化方法调用之前调用的方法
     * @param o 处理的对象
     * @param s 对象在上下文中的名称
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("beanPostProcessor before initialization run ...");
        if (o instanceof ComplexPerson) {
            ComplexPerson person = (ComplexPerson) o;
            System.out.println("BeanPostProcessor在对象初始化之前对person进行属性改造");
            person.setName("songdan before init");
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("beanPostProcessor after initialization run ...");
        if (o instanceof ComplexPerson) {
            ComplexPerson person = (ComplexPerson) o;
            System.out.println("BeanPostProcessor在对象初始化之后对person进行属性改造"+s);
            person.setName("songdan after init");
        }
        return o;
    }
}
