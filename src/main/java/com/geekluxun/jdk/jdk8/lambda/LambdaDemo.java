package com.geekluxun.jdk.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-03-19 9:25
 * @Description:
 * @Other:
 */
public class LambdaDemo {
    public static void main(String[] argc) {
        LambdaDemo demo = new LambdaDemo();
        demo.demo1();
        demo.demo2();
    }

    private void demo1() {
        int port = 8000;
        Runnable r = () -> System.out.println(port);
        // Lambda表达式引用的局部变量必须是final的!!!
        //port = 33;
    }

    private void demo2() {
        List<String> list = new ArrayList<>();
        // 把Lambda表达式赋给目标类型，如果和目标类型匹配，就能赋值
        Predicate<String> p = (e) -> list.add(e);

        // 谓词复合
        p.and(p).or(p).negate();

        boolean result = p.test("dd");
        System.out.println(result);
    }


    /**
     * 方法引用的3中方式
     */
    private void demo3() {
        BiPredicate<List<String>, String> p = List::contains;
        Function<String, Integer> f = Integer::parseInt;

        Function<Integer, String> g = (a) -> a + "";
        // 函数复合 g(f(x))
        f.andThen(g);

        // 函数复合 f(g(x));
        f.compose(g);

        LambdaDemo demo = new LambdaDemo();
        //Consumer c = demo :: demo2;
    }
}
