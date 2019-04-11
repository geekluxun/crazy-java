package com.geekluxun.effectivejava.chapter5.item26;

import java.util.ArrayList;
import java.util.List;

// Fails at runtime - unsafeAdd method uses a raw type (List)!  (Page 119)
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    /**
     * 不要使用原生类型，List是原生类型，没有类型检查，导致运行时失败
     * List<?> 不能把除了null之外的任何类型放进去...
     * 原生类型只在List.class时候使用
     *
     * @param list
     * @param o
     */
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}

