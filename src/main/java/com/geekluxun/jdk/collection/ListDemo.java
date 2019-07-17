package com.geekluxun.jdk.collection;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: luxun
 * @Create: 2019-07-10 15:18
 * @Description:
 * @Other:
 */
public class ListDemo {

    public static void main(String[] argc) {
        ListDemo demo = new ListDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
    }

    /**
     * subList示例
     */
    public void demo1() {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        List list2 = list.subList(0, 1);
        System.out.println("list2:" + JSON.toJSONString(list2));
    }


    /**
     * list转数组
     */
    public void demo2() {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        // 长度为0效率最高
        String[] array = list.toArray(new String[0]);
        Arrays.stream(array).forEach((e) -> System.out.println(e));
    }

    /**
     * 数组转list
     */
    public void demo3() {
        String[] array = {"1", "2", "3", "4", "5"};
        // 只是数组的一个视图
        List list = Arrays.asList(array);

        System.out.println("list:" + JSON.toJSONString(list));
        try {
            // 此处通过数组转换来的list是只读的，不能增删改
            list.add("6");
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

}
