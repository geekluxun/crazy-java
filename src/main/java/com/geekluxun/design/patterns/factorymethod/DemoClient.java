package com.geekluxun.design.patterns.factorymethod;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:47
 * @Description:
 * @Other:
 */
public class DemoClient  {
    public static void main(String[] argc) {
        ConcretePizzaCreator productCreator = new ConcretePizzaCreator();
        Pizza pizza = productCreator.orderProduct("haixian");
        System.out.println("我是：" + pizza.getName());

        Pizza pizza2 = productCreator.orderProduct("zhishi");
        System.out.println("我是：" + pizza2.getName());
    }
}
