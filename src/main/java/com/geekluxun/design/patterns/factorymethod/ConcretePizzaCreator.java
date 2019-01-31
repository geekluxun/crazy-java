package com.geekluxun.design.patterns.factorymethod;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:26
 * @Description: 工厂方法具体类
 * @Other:
 */
public class ConcretePizzaCreator extends PizzaCreator {
    /**
     * 对象的实例化推迟到子类完成
     *
     * @param type
     * @return
     */
    @Override
    Pizza createProduct(String type) {
        if (type.equals("haixian")) {
            return new ConcretePizza1();
        } else if (type.equals("zhishi")) {
            return new ConcretePizza2();
        }
        return null;
    }

}