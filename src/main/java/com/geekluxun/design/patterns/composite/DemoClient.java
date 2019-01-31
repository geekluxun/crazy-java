package com.geekluxun.design.patterns.composite;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-31 9:36
 * @Description:
 * @Other:
 */
public class DemoClient {
    public static void main(String[] argc) {
        Menu menu = new Menu("明星大厨菜单1", "5星级大厨");
        MenuItem menuItem1 = new MenuItem("宫保鸡丁", "川菜", 10, false);
        MenuItem menuItem2 = new MenuItem("鱼香肉丝", "川菜", 30, false);
        menu.add(menuItem1);
        menu.add(menuItem2);
        // 打印菜单
        menu.print();
    }
}
