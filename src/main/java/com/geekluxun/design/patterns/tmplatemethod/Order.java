package com.geekluxun.design.patterns.tmplatemethod;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 13:12
 * @Description:
 * @Other:
 */
public abstract class Order {


    /**
     * 模板方法 ，其中tranfer是抽象方法，由子类提供算法
     *
     * @param productName
     */
    public void order(String productName) {
        reduceStock(productName);
        packageProduct(productName);
        // 算法的可选步骤,可以由子类灵活决定是否执行此步骤
        if (isNotifyUser()) {
            notifyUser();
        }
        tranfer(productName);
    }

    private void reduceStock(String productName) {
        System.out.println("从库存中扣减商品：" + productName);
    }

    private void packageProduct(String productName) {
        System.out.println("打包商品：" + productName);
    }

    public abstract void tranfer(String productName);

    private void notifyUser() {
        System.out.println("通知用户");
    }

    /**
     * 钩子
     *
     * @return
     */
    public boolean isNotifyUser() {
        return false;
    }
}
