package com.geekluxun.guava.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;

import java.util.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 14:42
 * @Description: 不可变集合示例
 * @Other:
 */
public class ImmutableCollectionDemo { 
    public static void main(String[] argc){
        ImmutableCollectionDemo demo = new ImmutableCollectionDemo();
        demo.demo1();
        demo.demo2();
    }

    
    private void demo1(){
        ImmutableSet<String> color = ImmutableSet.of("red", "blue", "yellow");
        color.asList();
        System.out.println(color);

        ImmutableList<String> color2 = ImmutableList.of("red", "blue");
        // 遍历元素方式1 通过函数式接口
        color2.forEach((e)->handleElement(e));

        // 遍历元素方式2 通过迭代器
        Iterator iterator = color2.iterator();
        while (iterator.hasNext()){
            handleElement(iterator.next());
        }
    }
    
    private void demo2(){
        Map map = new HashMap(10);
        map.put("b", 1);
        map.put("e", 2);
        map.put("a", "luxun");
        // 打印出来是按照key有序 map:{a=3, b=1, e=2} 为啥？？
        System.out.println("map:" + map);

        // 使用自然排序Comparable排序，,map是按照key排序的，key是字符串，字符串排序是按照字典序排序
        ImmutableSortedMap<String, Object> sortedMap = ImmutableSortedMap.copyOf(map);
        sortedMap.forEach((k,v)->System.out.println("key:" + k +  " value:" + v));
        
    }

    /**
     * 处理每个元素，封装成一个方法
     * @param item
     * @param <E>
     */
    private <E> void handleElement(E item){
        System.out.println("元素:" + item);
    }
}
