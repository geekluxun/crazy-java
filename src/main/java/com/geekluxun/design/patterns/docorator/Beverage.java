package com.geekluxun.design.patterns.docorator;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:03
 * @Description: 被装饰者抽象类(饮料)
 * @Other:
 */
public abstract class Beverage {
    /**
     * 饮料描述
     * @return
     */
    public abstract String getDesc();

    /**
     * 饮料价格
     * @return
     */
    public abstract float getCost();
}
