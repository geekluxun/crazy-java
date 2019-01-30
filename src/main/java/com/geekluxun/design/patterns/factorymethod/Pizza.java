package com.geekluxun.design.patterns.factorymethod;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:23
 * @Description:
 * @Other:
 */
public abstract class Pizza {
    private String name;
    private Float cost;


    public String getName() {
        return name;
    }

    public Float getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    /**
     * 准备
     */
    public void prepare() {
        System.out.println("Preparing " + name);
    }

    /**
     * 烘烤
     */
    public void bake() {
        System.out.println("Baking " + name);
    }

    /**
     * 切片
     */
    public void cut() {
        System.out.println("Cutting " + name);
    }

    /**
     * 包装
     */
    public void box() {
        System.out.println("Boxing " + name);
    }
}
