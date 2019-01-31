package com.geekluxun.design.patterns.facade;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:07
 * @Description:
 * @Other:
 */
public class Transport {
    public void tranfer(String productName) {
        System.out.println("物流运输商品" + productName);
    }
}
