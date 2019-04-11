package com.geekluxun.jdk.generics;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-04-01 16:25
 * @Description:
 * @Other:
 */
public class LinkedStack<U> {
    private static class Node<T> {
        T item;
        Node<T> next;
    }
}
