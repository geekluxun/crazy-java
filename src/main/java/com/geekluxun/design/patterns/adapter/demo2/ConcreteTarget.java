package com.geekluxun.design.patterns.adapter.demo2;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-07-16 14:24
 * @Description:
 * @Other:
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("目标对象接收请求");
    }
}
