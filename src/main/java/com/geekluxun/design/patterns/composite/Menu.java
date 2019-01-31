package com.geekluxun.design.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 9:17
 * @Description:
 * @Other:
 */
public class Menu implements MenuComponet {
    private List<MenuComponet> menuComponents = new ArrayList();
    private String name;
    private String description;


    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }


    @Override
    public void add(MenuComponet menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponet menuComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MenuComponet getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print() {
        System.out.println("name:" + name + "description:" + description);
        menuComponents.stream().forEach(menuComponet -> menuComponet.print());
    }
}
