package com.geekluxun.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 17:32
 * @Description: 双向map
 * @Other:
 */
public class BiMapDemo {
    public static void main(String[] argc){
        BiMapDemo demo = new BiMapDemo();
        demo.demo1();
    }
    
    private void demo1(){
        BiMap map = HashBiMap.create();
        map.put("luxun", 1);
        map.put("luxun2", 2);
        map = map.inverse();
        
        System.out.println(map);
    }
}
