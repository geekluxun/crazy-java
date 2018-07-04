package com.geekluxun.guava.collections;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import lombok.Data;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: luxun
 * @Create: 2018-06-30 14:16
 * @Description: 工具类Lists Sets Maps Queues示例
 * @Other:
 */
public class ListsSetsMapsQueuesDemo {

    public static void main(String[] argc){
        ListsSetsMapsQueuesDemo demo = new ListsSetsMapsQueuesDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4();
        demo.demo5();
        demo.demo6();
        demo.demo7();
    }

    /**
     * 逆序、分割原有list
     */
    private void demo1(){
        List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
        // {5, 4, 3, 2, 1}
        List<Integer> countDown = Lists.reverse(countUp);
        // {{1, 2}, {3, 4}, {5}
        List<List<Integer>> parts = Lists.partition(countUp, 2);

        System.out.println();
    }

    /**
     * 笛卡尔积
     */
    private void demo2(){
        //外部共有 3*3个element 内部的每个list都有2个element
        List<List<Integer>>  c = Lists.cartesianProduct(Ints.asList(1,2,3), Ints.asList(4,5,6));


        List<List<Object>> c2 = Lists.cartesianProduct(
                ImmutableList.of(ImmutableList.of(1, 2),
                ImmutableList.of("A", "B", "C")));

        // 9个list进行笛卡尔积 每个list都有2个element 共 2的9次方
        List<List<Integer>> c3 = Lists.cartesianProduct(c);

        System.out.println();
    }

    /**
     *
     */
    private void demo3(){
        CopyOnWriteArrayList list = Lists.newCopyOnWriteArrayList(Ints.asList(1,2,4,6));
        LinkedList linkedList = Lists.newLinkedList(list);
        ArrayList arrayList = Lists.newArrayList(linkedList);
    }

    /**
     *
     */
    private void demo4(){
        Set<Integer> a = ImmutableSet.of(1,2,3);
        Set<Integer> b = ImmutableSet.of(1,2,9);
        // 交集
        Sets.SetView<Integer> intersection = Sets.intersection(a, b);

        Set<Integer> c = intersection.immutableCopy();
        // 笛卡尔积
        Set<List<Integer>> dd = Sets.cartesianProduct(a, b);

        // 排列组合 null 1 2 3 12 13 23  123
        Set<Set<Integer>> d = Sets.powerSet(a);
        System.out.println();
    }

    /**
     *
     */
    private void demo5() {
        Set<Integer> a = ImmutableSet.of(1,2,3);
        Set<Integer> b = ImmutableSet.of(1,2,9);
        // 交集
        Sets.SetView<Integer> intersection = Sets.intersection(a, b);
        // 并集
        Sets.SetView<Integer> d2 = Sets.union(a, b);
        // 差集 属于a但不属于b
        Sets.SetView<Integer> d3 = Sets.difference(a, b);

        Sets.SetView<Integer> d4 = Sets.symmetricDifference(a, b);
        System.out.println();
    }

    /**
     *
     */
    private void demo6(){
        List<Person> personList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Person person = new Person();
            person.setId(i + 1);
            person.setName("luxun");
            person.setAge(10);
            personList.add(person);
        }

        // key 是id, value是 person！！！注意此处的id必须是唯一的！！！
        Map map = Maps.uniqueIndex(personList, (person) -> person.getId());
        map.forEach((k,v)->System.out.println(k +":" + v));
    }

    /**
     *
     */
    private void demo7(){
        Set<Integer> set1 = ImmutableSet.of(1,2,3);
        Set<Integer> set2 = ImmutableSet.of(2,3,6);
        // key为set的值 value由function返回值提供
        Map map1 = Maps.toMap(set1,(a)->a.intValue());
        Map map2 = Maps.toMap(set2,(a)->a.intValue());
        MapDifference mapDifference = Maps.difference(map1, map2);
        // key只在左边存在
        mapDifference.entriesOnlyOnLeft();
        // key只在右边存在
        mapDifference.entriesOnlyOnRight();
        System.out.println();
    }

    @Data
    private class Person{
        private Integer id;
        private String name;
        private Integer age;
    }
}
