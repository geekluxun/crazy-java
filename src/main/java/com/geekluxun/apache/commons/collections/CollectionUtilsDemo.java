package com.geekluxun.apache.commons.collections;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.Transformer;

import java.util.Collection;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-13 9:33
 * @Description:
 * @Other:
 */
public class CollectionUtilsDemo {
    public static void main(String[] argc) {
        CollectionUtilsDemo demo = new CollectionUtilsDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4();
        demo.demo5();
    }

    private void demo1() {
        List<String> listA = Lists.newArrayList("e", "c");
        List<String> listB = Lists.newArrayList("f", "a");
        // 连接好的list是有序的 所谓有序就是按照 两个list比较得到（原有list内部顺序不变）
        List<String> listAll = CollectionUtils.collate(listA, listB);
        listAll.forEach((e) -> System.out.println("元素" + e));
        System.out.println();
    }

    private void demo2() {
        List<Integer> listA = Lists.newArrayList(111, 222);
        Transformer<Integer, String> transformer = new myTransformer();
        // 转换成字符串
        Collection<String> result = CollectionUtils.collect(listA, transformer);
        System.out.println();
    }

    private void demo3() {
        List<Integer> listA = Lists.newArrayList(111);
        Integer element = CollectionUtils.extractSingleton(listA);
        System.out.println();
    }

    /**
     * 集合元素过滤
     */
    private void demo4() {
        Predicate predicate = PredicateUtils.falsePredicate();
        List<Integer> listA = Lists.newArrayList(1, 2, 3, 4);
        // 对每一个元素使用谓词逻辑，如果返回false（即不满足谓词逻辑），则删除掉此元素，整个方法返回true
        boolean result = CollectionUtils.filter(listA, predicate);
        // 逻辑正好相反
        CollectionUtils.filterInverse(listA, predicate);
        System.out.println();
    }


    private void demo5() {
        List<Integer> listA = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> listB = Lists.newArrayList(1, 2, 3, 4, 5);

        // a是b的子集
        boolean result = CollectionUtils.isSubCollection(listA, listB);

        listA = Lists.newArrayList(1, 2, 3, 4, 6, 8);
        listB = Lists.newArrayList(1, 2, 3, 4, 5);
        List<Integer> c = (List<Integer>) CollectionUtils.retainAll(listA, listB);
        // 符合谓词逻辑的挑选出来
        List<Integer> d = (List<Integer>) CollectionUtils.select(listA, PredicateUtils.truePredicate());
        System.out.println();
    }

    private static class myTransformer implements Transformer<Integer, String> {
        @Override
        public String transform(Integer o) {
            return o.toString();
        }
    }
}
