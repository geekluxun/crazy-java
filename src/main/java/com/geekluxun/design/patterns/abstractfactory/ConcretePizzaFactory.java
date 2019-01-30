package com.geekluxun.design.patterns.abstractfactory;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 16:12
 * @Description:
 * @Other:
 */
public class ConcretePizzaFactory extends PizzaFactory {
    
    @Override
    public Flavor createFlavor() {
        return new ConcreteFlavor1();
    }

    @Override
    public Flour createFlour() {
        return new ConcreteFlour1();
    }
}
