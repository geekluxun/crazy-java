package com.geekluxun.design.patterns.docorator;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:15
 * @Description: 装饰器提供了对现有类提供新的行为的一种方式，通过类似一层层装饰的方法，
 * client调用的是最完成装饰器，类似"俄罗斯套娃"，客户端使用的是最完成的套娃
 * @Other:
 */
public class DemoClient {

    public static void main(String[] argc) {
        AppleJuice juice = new AppleJuice();
        System.out.println("我是" + juice.getDesc() + " 价格:" + juice.getCost());

        // 被装饰者增加了新的行为
        Sugar beverage = new Sugar(juice);
        System.out.println("加了糖后,我是" + beverage.getDesc() + " 价格:" + beverage.getCost());
    }
}
