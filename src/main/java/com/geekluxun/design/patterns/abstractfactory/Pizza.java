package com.geekluxun.design.patterns.abstractfactory;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 16:13
 * @Description: 披萨（抽象类）
 * @Other:
 */
public abstract class Pizza {
    private Flour flour;
    private Flavor flavor;
    
    
    abstract void prepare();

    protected Flavor getFlavor() {
        return flavor;
    }
    
    protected Flour getFlour(){
        return flour;
    }

    public void setFlour(Flour flour) {
        this.flour = flour;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }
}
