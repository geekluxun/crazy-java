package com.geekluxun.design.patterns.composite;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 9:14
 * @Description:
 * @Other:
 */
public interface MenuComponet {
    void add(MenuComponet menuComponent);

    void remove(MenuComponet menuComponent);

    MenuComponet getChild(int i);

    String getName();

    String getDescription();

    double getPrice();

    boolean isVegetarian();

    void print();
}
