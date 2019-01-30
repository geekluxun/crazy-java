package com.geekluxun.design.patterns.docorator;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:12
 * @Description: 装饰者具体类(加了糖的饮料)
 * @Other:
 */
public class Sugar extends  Decorator {
    /**
     * 被装饰者（饮料）
     */
    private Beverage beverage;
  
    
    public Sugar(Beverage beverage){
        this.beverage = beverage;    
    }
    
    @Override
    public String getDesc() {
        return beverage.getDesc() + "另外加了糖";
    }

    @Override
    public float getCost() {
        return beverage.getCost() + 2.3f;
    }
}
