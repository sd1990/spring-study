package org.songdan.spring.study.bean.lifecycle;

/**
 * 最普通的spring bean POJO
 * Created by SongDan on 2017/3/23.
 */
public class Person {

    private String name;

    public Person() {
        System.out.println("Person Bean 构造函数执行");
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
    }

    public void destroyMethod() {
        System.out.println("destroy method run ...");
    }
}
