package com.geekluxun.guava.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 15:50
 * @Description:
 * @Other:
 */
public class MultiSetDemo {
    private String[] words = {"luxun", "geek", "luxun", "hello", "geek", "world"};
    public static void main(String[] argc){
        MultiSetDemo demo = new MultiSetDemo();
        demo.demo1();
    }

    /**
     * mulutset介于list set之前（类似两种的混合）， list可以有重复元素，有序， set不重复，但无序
     */
    private void demo1(){
        Multiset<String> counts = HashMultiset.create();
        counts.addAll(Arrays.asList(words));
        System.out.println("multiset总数:" + counts.size());
        // 不重复的元素集合（去重）
        Set set = counts.elementSet();
        System.out.println("去重后set总数:" + set.size());

        Set<Multiset.Entry<String>> set2 = counts.entrySet();
        System.out.println("set2:" + set2);
        // 打印出每个不重复元素值和对应个数
        set2.forEach((e)-> System.out.println(e.getElement() + ":" + e.getCount()));
    }

    /**
     * 传统JDK方式统计每个字符串出现次数
     */
    private void demo2(){
        Map<String, Integer> counts = new HashMap<String, Integer>(10);
        for (String word : words) {
            Integer count = counts.get(word);
            if (count == null) {
                counts.put(word, 1);
            } else {
                counts.put(word, count + 1);
            }
        }
        TreeMap map;
    }
}
