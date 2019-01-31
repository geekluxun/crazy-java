package com.geekluxun.design.patterns.facade;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:08
 * @Description: 库存
 * @Other:
 */
public class Stock {
    public void reduceStock(String productName) {
        System.out.println("从库存中扣减商品：" + productName);
    }
}
