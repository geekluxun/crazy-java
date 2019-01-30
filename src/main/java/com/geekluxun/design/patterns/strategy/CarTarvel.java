package com.geekluxun.design.patterns.strategy;

/**
 * @Author: luxun
 * @Create: 2019-01-30 21:44
 * @Description:
 * @Other:
 */
public class CarTarvel implements Travel {
    @Override
    public void travel() {
        System.out.println("乘坐汽车出行...");
    }
}
