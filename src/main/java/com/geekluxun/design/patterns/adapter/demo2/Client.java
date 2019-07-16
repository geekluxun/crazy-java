package com.geekluxun.design.patterns.adapter.demo2;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-07-16 13:53
 * @Description:
 * @Other:
 */
public class Client {

    public static void main(String[] argc) {
        Client client = new Client();
        client.demo1();
    }

    /**
     * 客户端向target发起请求
     */
    public void demo1() {
        // 被适配者适配成目标对象
        Target target = new Adapter(new ConcreteAdaptee());
        //  向目标对象发起请求
        target.request();

        // 反向适配
        Adaptee adaptee = new Adapter(new ConcreteTarget());
        adaptee.sepecficRequest();
    }
}
