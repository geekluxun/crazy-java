package com.geekluxun.design.patterns.composite;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 9:34
 * @Description:
 * @Other:
 */
public class MenuItem implements MenuComponet {
    private String name;
    private String description;
    private double price;
    private boolean vegetarian;


    public MenuItem(String name, String description, double price, boolean vegetarian) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetarian = vegetarian;
    }

    @Override
    public void add(MenuComponet menuComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(MenuComponet menuComponent) {
        throw new UnsupportedOperationException();

    }

    @Override
    public MenuComponet getChild(int i) {
        throw new UnsupportedOperationException();
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
        return this.price;
    }

    @Override
    public boolean isVegetarian() {
        return this.vegetarian;
    }

    @Override
    public void print() {
        System.out.println("name:" + name + "description:" + description);
    }
}
