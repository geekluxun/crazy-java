package com.geekluxun.apache.commons.collections;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.OrderedMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: luxun
 * @Create: 2018-07-14 10:15
 * @Description:
 * @Other:
 */
public class MapUtilsDemo {
    public static void main(String[] argc) {
        MapUtilsDemo demo = new MapUtilsDemo();
        demo.demo1();
    }


    private void demo1() {
        Map map = new TreeMap();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("aa", 3);
        map.put("d", 4);

        Map map2 = MapUtils.invertMap(map);

        // 不需要 entryset就可以迭代map
        IterableMap iterableMap = MapUtils.iterableMap(map);
        MapIterator iterator = iterableMap.mapIterator();
        while (iterator.hasNext()) {
            iterator.next();
            System.out.println("key:" + iterator.getKey());
            iterator.getValue();
        }

        // 也是可迭代的
        OrderedMap orderedMap = MapUtils.orderedMap(map);

        orderedMap.nextKey(orderedMap.firstKey());

        // 返回一个不可修改的map(不能add delete)
        map = MapUtils.unmodifiableMap(map);
        map.put("key3", 6);
        System.out.println();
    }
}
