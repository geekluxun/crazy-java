package com.geekluxun.design.patterns.abstractfactory;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 16:17
 * @Description:
 * @Other:
 */
public class CheesePizza extends Pizza {
    /**
     * 抽象工厂
     */
    private PizzaFactory pizzaFactory;
    
    public CheesePizza(PizzaFactory pizzaFactory){
        this.pizzaFactory = pizzaFactory;
        prepare();
    }

    /**
     * 通过抽象工厂来生产披萨的各个零部件（面粉、调料）
     */
    @Override
    void prepare() {
        setFlavor(pizzaFactory.createFlavor());
        setFlour(pizzaFactory.createFlour());

    }    

    @Override
    public String toString() {
        return "我是芝士披萨：" + "调料:" + getFlavor() + "面粉：" + getFlour();
    }
}
