package com.geekluxun.design.patterns.proxy;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:22
 * @Description:
 * @Other:
 */
public class PersonImpl implements Person {

    @Override
    public void sayHello() {
        System.out.println("hello world!!!");
    }

    @Override
    public void setName(String name) {
        System.out.println("设置姓名：" + name);
    }
}
