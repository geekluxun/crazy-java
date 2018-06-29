package com.geekluxun.jdk.jdk8.optional;

import java.util.Optional;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-28 14:50
 * @Description:
 * @Other:
 */
public class Person {

    private Optional<Car> car;
    
    private String name; 

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
