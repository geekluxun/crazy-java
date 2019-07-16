package com.geekluxun.design.patterns.tmplatemethod;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 13:28
 * @Description:
 * @Other:
 */
public class PlainOrder extends Order {

    @Override
    public void tranfer(String productName) {
        System.out.println("使用飞机运输商品" + productName);
    }
    
    @Override
    public boolean isNotifyUser() {
        return true;
    }
}
