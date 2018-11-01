package com.geekluxun.apache.commons.lang.builder;


/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 14:42
 * @Description:
 * @Other:
 */
public class ReflectionToStringBuilderDemo {
    public static void main(String[] argc) {
        ReflectionToStringBuilderDemo demo = new ReflectionToStringBuilderDemo();
        demo.demo1();
    }

    private void demo1() {
        Child child = new Child();
        child.setCf1("c1");
        child.setCf2("c2");
        child.setPf1("luxun");
//        Parent parent = new Parent();
//        parent.setPf1("p111");
        //child.setParent(parent);

        String s = child.toString();
        System.out.println();
    }
}
