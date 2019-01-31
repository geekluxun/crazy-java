package com.geekluxun.design.patterns.abstractfactory;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 15:55
 * @Description: 披萨抽象工厂(假设披萨是调料 、 面粉组装而成)
 * @Other:
 */
public abstract class PizzaFactory {

    public abstract Flavor createFlavor();

    public abstract Flour createFlour();
}
