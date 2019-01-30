package com.geekluxun.design.patterns.abstractfactory;

import com.geekluxun.design.patterns.factorymethod.Pizza;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:25
 * @Description: 工厂方法(抽象,创建披萨) 抽象工厂方法适合那些对象创建比较复杂，
 * 需要很多步骤才能完成的场景
 * @Other:
 */
public abstract class PizzaCreator {
    abstract Pizza createProduct(String type);
    
    public Pizza orderProduct(String type){
        // 需要很多步骤才能真正完成整个披萨的制作过程
        Pizza pizza = createProduct(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
