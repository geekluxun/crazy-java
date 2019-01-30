package com.geekluxun.design.patterns.strategy;

/**
 * @Author: luxun
 * @Create: 2019-01-30 21:47
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc){
        Person person = new Person(new CarTarvel());
        person.travel();

        // 动态改变行为（策略）
        person.setTravel(new TrainTravel());
        person.travel();
    }
}
