package com.geekluxun.jdk.collection;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 16:33
 * @Description:
 * @Other:
 */
public class TreeMapDemo {
    public static void main(String[] argc){
        TreeMapDemo demo = new TreeMapDemo();
        demo.demo1();
        demo.demo2();
    }
    
    private void demo1(){
        
        TreeMap map21 = new TreeMap();
        map21.put("key211", "211");
        map21.put("key212", "212");

        TreeMap map222 = new TreeMap();
        map222.put("key2221", "2221");
        
        TreeMap map22 = new TreeMap();
        map22.put("key221", "221");
        map22.put("key222", map222);

        TreeMap map23 = new TreeMap();
        map23.put("key231", "231");
        map23.put("key232", "232");

        TreeMap map1 = new TreeMap();
        map1.put("key1", map21);
        map1.put("key2", map22);
        map1.put("key3", map23);

        Set key = map1.keySet();
        System.out.println(key);
        
        map1.forEach((k,v)->System.out.println(k + ":" + v));
    }


    private void demo2(){

        HashMap map21 = new HashMap(10);
        map21.put("key211", "211");
        map21.put("key212", "212");

        HashMap map222 = new HashMap(10);
        map222.put("key2221", "2221");

        HashMap map22 = new HashMap(10);
        map22.put("key221", "221");
        map22.put("key222", map222);

        HashMap map23 = new HashMap(10);
        map23.put("key231", "231");
        map23.put("key232", "232");

        HashMap map1 = new HashMap(10);
        map1.put("key1", map21);
        map1.put("key2", map22);
        map1.put("key3", map23);

        Set key = map1.keySet();
        System.out.println(key);
        
        map1.forEach((k,v)->System.out.println(k + ":" + v));
    }
}
