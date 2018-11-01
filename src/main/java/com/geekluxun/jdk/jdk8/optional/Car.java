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
public class Car {

    private Optional<Insurance> insurance;

    private String brand;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
