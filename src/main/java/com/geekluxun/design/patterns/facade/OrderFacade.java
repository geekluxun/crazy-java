package com.geekluxun.design.patterns.facade;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 10:05
 * @Description:
 * @Other:
 */
public class OrderFacade {
    Package aPackage = new Package();
    Stock stock = new Stock();
    Transport transport = new Transport();

    /**
     * 提供给客户单的门面方法
     *
     * @param productName
     */
    public void order(String productName) {
        stock.reduceStock(productName);
        aPackage.packageProduct(productName);
        transport.tranfer(productName);
    }
}
