package com.geekluxun.effectivejava.chapter5.item30;

import java.util.HashSet;
import java.util.Set;

// Generic union method and program to exercise it  (Pages 135-6)
public class Union {

    // Generic method

    /**
     * 泛型方法示例
     *
     * @param s1
     * @param s2
     * @param <E>
     * @return
     */
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise generic method
    public static void main(String[] args) {
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }
}
