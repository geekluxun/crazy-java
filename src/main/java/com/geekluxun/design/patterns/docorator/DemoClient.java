package com.geekluxun.design.patterns.docorator;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-30 14:15
 * @Description:
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
