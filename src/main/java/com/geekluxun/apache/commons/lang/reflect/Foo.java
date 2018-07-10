package com.geekluxun.apache.commons.lang.reflect;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 17:08
 * @Description:
 * @Other:
 */
public class Foo{
    static String date;
    private String name;
    private Integer age;

    public Integer getAge() {
        System.out.println("======getAge=====");
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("======setAge=====");
        this.age = age;
    }

    public String getName() {
        System.out.println("======getName=====");
        return name;
    }

    public void setName(String name) {
        System.out.println("======setName=====");
        this.name = name;
    }
}
