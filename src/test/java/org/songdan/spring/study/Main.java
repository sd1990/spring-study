package org.songdan.spring.study;

import org.songdan.spring.study.bean.lifecycle.ComplexPerson;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动类
 * Created by SongDan on 2017/3/23.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        ComplexPerson person = context.getBean(ComplexPerson.class);
        System.out.println(person.getName());
        context.destroy();
    }

}
