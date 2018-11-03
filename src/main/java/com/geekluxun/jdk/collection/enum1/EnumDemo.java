package com.geekluxun.jdk.collection.enum1;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * @Author: luxun
 * @Create: 2018-11-02 16:52
 * @Description:
 * @Other:
 */
public class EnumDemo {
    public static void main(String[] argc) {
        EnumDemo demo = new EnumDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
    }


    public void demo1() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatusEnum.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatusEnum.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatusEnum.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatusEnum.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pzList);
        Assert.isTrue(undeliveredPzs.size() == 3);
    }

    /**
     * EnumMap示例
     */
    public void demo2() {
        List<Pizza> pzList = new ArrayList<>();
        Pizza pz1 = new Pizza();
        pz1.setStatus(Pizza.PizzaStatusEnum.DELIVERED);

        Pizza pz2 = new Pizza();
        pz2.setStatus(Pizza.PizzaStatusEnum.ORDERED);

        Pizza pz3 = new Pizza();
        pz3.setStatus(Pizza.PizzaStatusEnum.ORDERED);

        Pizza pz4 = new Pizza();
        pz4.setStatus(Pizza.PizzaStatusEnum.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        EnumMap<Pizza.PizzaStatusEnum, List<Pizza>> map = Pizza.groupPizzaByStatus(pzList);
        Assert.isTrue(map.get(Pizza.PizzaStatusEnum.DELIVERED).size() == 1);
        Assert.isTrue(map.get(Pizza.PizzaStatusEnum.ORDERED).size() == 2);
        Assert.isTrue(map.get(Pizza.PizzaStatusEnum.READY).size() == 1);

    }

    public void demo3() {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatusEnum.READY);
        pz.deliver();
        Assert.isTrue((pz.getStatus() == Pizza.PizzaStatusEnum.DELIVERED));
    }
}
