package com.geekluxun.apache.commons.collections;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.Predicate;

import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-13 15:11
 * @Description:
 * @Other:
 */
public class IterableUtilsDemo {
    public static void main(String[] argc) {
        IterableUtilsDemo demo = new IterableUtilsDemo();
        demo.demo1();
    }

    /**
     * 按照谓词分区
     */
    private void demo1() {
        List<Integer> list = Lists.newArrayList(1, 3, 7, 9, 10, 6, 11, 10, 8, 0, 3, 12);
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer o) {
                return o.longValue() < 5;
            }
        };

        Predicate<Integer> predicate2 = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer o) {
                return o.longValue() < 8;
            }
        };
        // 一个谓词匹配
        List<List<Integer>> partion = IterableUtils.partition(list, predicate);
        // 两个谓词匹配
        partion = IterableUtils.partition(list, predicate, predicate2);
        System.out.println();

        IterableUtils.boundedIterable(list, 5);
        Iterable iterable = IterableUtils.chainedIterable(list, list);
        IterableUtils.emptyIfNull(null);
        Iterable iterable2 = IterableUtils.filteredIterable(list, predicate);
        // 出现的次数
        int count = IterableUtils.frequency(list, 10);
        IterableUtils.toList(iterable);
        // 去重
        IterableUtils.uniqueIterable(list);

        Iterable iterable3 = IterableUtils.zippingIterable(iterable, iterable2);
        System.out.println();
    }
}
