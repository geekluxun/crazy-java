package com.geekluxun.jdk.generics;

import java.util.List;

/**
 * @Author: luxun
 * @Create: 2019-07-10 15:54
 * @Description:
 * @Other:
 */
public class GenericsDemo {
    public static void main(String[] argc) {

    }

    public void demo1() {

    }


    /**
     * super适合插入数据
     *
     * @param list
     * @param <E>
     */
    private <E> void add(List<? super E> list) {

    }

    /**
     * extend时候获取数据
     *
     * @param <E>
     * @return
     */
    private <E> List<? extends E> get() {
        return null;
    }

}
