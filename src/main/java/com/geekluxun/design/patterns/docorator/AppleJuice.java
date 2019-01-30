package com.geekluxun.design.patterns.docorator;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:07
 * @Description: 被装饰者具体类（苹果汁）
 * @Other:
 */
public class AppleJuice extends Beverage {
    
    @Override
    public String getDesc() {
        return "苹果汁";
    }

    @Override
    public float getCost() {
        return 1.2f;
    }
}
