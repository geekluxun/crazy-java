package com.geekluxun.design.patterns.proxy;

import java.lang.reflect.Proxy;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:28
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc) {
        Person person = new PersonImpl();
        person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), person.getClass().getInterfaces(), new PersonInvocationHandler(person));
        person.sayHello();
        person.setName("luxun");
    }
}
