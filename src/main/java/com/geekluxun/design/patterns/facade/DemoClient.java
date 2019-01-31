package com.geekluxun.design.patterns.facade;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:12
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc) {
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.order("华为Mate20");
    }
}
