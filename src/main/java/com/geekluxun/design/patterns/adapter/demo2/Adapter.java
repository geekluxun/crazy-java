package com.geekluxun.design.patterns.adapter.demo2;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-07-16 14:00
 * @Description: 双向适配器
 * @Other:
 */
public class Adapter implements Target, Adaptee {
    /**
     * 被适配的对象
     */
    private Adaptee adaptee;

    private Target target;


    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public Adapter(Target target) {
        this.target = target;
    }

    @Override
    public void request() {
        adaptee.sepecficRequest();
    }

    @Override
    public void sepecficRequest() {
        target.request();
    }
}
