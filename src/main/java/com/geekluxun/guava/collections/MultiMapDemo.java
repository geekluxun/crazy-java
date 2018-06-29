package com.geekluxun.guava.collections;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 16:58
 * @Description:
 * @Other:
 */
public class MultiMapDemo {
    public static void main(String[] argc){
        MultiMapDemo demo = new MultiMapDemo();
        demo.demo1();
        
    }

    /**
     * 一个key映射到多个值 如key4
     */
    private void demo1(){
        ListMultimap<String, Integer> map = MultimapBuilder.treeKeys().arrayListValues().build();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        List<Integer> value4 = Arrays.asList(40,41,42);
        map.putAll("key4", value4);
        
        map.forEach((k,v)->System.out.println(k + ":" + v));

        value4 = map.get("key4");
    }
}
