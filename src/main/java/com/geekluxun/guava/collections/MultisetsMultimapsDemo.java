package com.geekluxun.guava.collections;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.springframework.util.Assert;

/**
 * @Author: luxun
 * @Create: 2018-06-30 16:40
 * @Description:
 * @Other:
 */
public class MultisetsMultimapsDemo {

    public static void main(String[] argc) {
        MultisetsMultimapsDemo demo = new MultisetsMultimapsDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
    }

    private void demo1() {
        Multiset multiset = HashMultiset.create();
        multiset.add(1);
        multiset.add(2);
        multiset.add(3);
        multiset.add(4);
        multiset.add(5);

        Multiset multiset2 = HashMultiset.create();
        multiset2.add(1);
        boolean result = Multisets.containsOccurrences(multiset, multiset2);
        Assert.isTrue(result);

        // 此时因为有了2个"1",所以super.count(o) < sub.count(0) 返回false
        multiset2.add(1);
        result = Multisets.containsOccurrences(multiset, multiset2);
        Assert.isTrue(!result);
        System.out.println();
    }

    /**
     * 区别与Maps.uniqueIndex 此处一个key映射到多个value
     */
    private void demo2() {
        ImmutableSet<String> digits = ImmutableSet.of(
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine");

        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String string) {
                return string.length();
            }
        };

        ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);

        digitsByLength.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));
        /*
         * digitsByLength maps:
         *  3 => {"one", "two", "six"}
         *  4 => {"zero", "four", "five", "nine"}
         *  5 => {"three", "seven", "eight"}
         */
    }

    /**
     * 交换k,v映射
     */
    private void demo3() {

        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));

        Multimap multimap2 = TreeMultimap.<String, Integer>create();

        Multimaps.invertFrom(multimap, multimap2);

        multimap2.forEach((k, v) -> System.out.println(k + ":" + v));
        // note that we choose the implementation, so if we use a TreeMultimap, we get results in order
        /*
         * inverse maps:
         *  1 => {"a"}
         *  2 => {"a", "b", "c"}
         *  3 => {"c"}
         *  4 => {"a", "b"}
         *  5 => {"c"}
         *  6 => {"b"}
         */
    }
}
