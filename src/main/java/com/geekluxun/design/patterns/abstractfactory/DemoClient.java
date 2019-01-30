package com.geekluxun.design.patterns.abstractfactory;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 16:23
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc){
        ConcretePizzaFactory factory = new ConcretePizzaFactory();
        Pizza pizza = new CheesePizza(factory);
        System.out.println("披萨:" + pizza);
    }
}
