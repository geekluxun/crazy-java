package com.geekluxun.design.patterns.tmplatemethod;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 13:30
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc) {
        PlainOrder order = new PlainOrder();
        order.order("遥控汽车");
    }
}
