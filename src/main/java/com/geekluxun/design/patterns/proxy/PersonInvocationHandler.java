package com.geekluxun.design.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:23
 * @Description:
 * @Other:
 */
public class PersonInvocationHandler implements InvocationHandler {
    /**
     * 被代理的person
     */
    private Person person;

    public PersonInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 此处对所有的方法调用进行了拦截
         */
        if (method.getName().startsWith("set")) {
            throw new IllegalAccessException("不允许调用set方法");
        }
        return method.invoke(person, args);
    }
}
