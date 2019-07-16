package com.geekluxun.design.patterns.adapter.demo2;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-07-16 14:17
 * @Description:
 * @Other:
 */
public class ConcreteAdaptee implements Adaptee {
    @Override
    public void sepecficRequest() {
        System.out.println("接收请求");
    }
}
