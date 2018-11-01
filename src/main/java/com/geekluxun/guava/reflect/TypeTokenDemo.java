package com.geekluxun.guava.reflect;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-04 9:08
 * @Description: 主要解决jdk类型擦除问题
 * @Other:
 */
public class TypeTokenDemo {
    public static void main(String[] argc) {
        TypeTokenDemo demo = new TypeTokenDemo();
        demo.demo1();
        demo.demo2();
        demo.demo3();
        demo.demo4();
    }


    public void demo1() {
        // 类型擦除 运行时类型参数被擦除
        ArrayList<String> stringList = Lists.newArrayList();
        ArrayList<Integer> intList = Lists.newArrayList();
        System.out.println(stringList.getClass().isAssignableFrom(intList.getClass()));

        // TypeToken解决这个问题
        TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {
        };
        // ArrayList只有一个类型参数 所以数组长度是1
        TypeToken<?> genericTypeToken = typeToken.resolveType(ArrayList.class.getTypeParameters()[0]);
        System.out.println(genericTypeToken.getType());
    }

    private void demo2() {
        TypeToken<String> stringTypeToken = TypeToken.of(String.class);

        TypeToken<Map<String, BigInteger>> mapToken = mapToken(
                TypeToken.of(String.class),
                TypeToken.of(BigInteger.class)
        );
        /**
         * type:java.util.Map<java.lang.String, java.math.BigInteger>
         * rawtype:interface java.util.Map
         */
        System.out.println("type:" + mapToken.getType());
        // 运行时类型
        System.out.println("rawtype:" + mapToken.getRawType());
        // String
        TypeToken<?> keyTypeToken = mapToken.resolveType(Map.class.getTypeParameters()[0]);
        System.out.println("keyTypeToken:" + keyTypeToken.getType());
        // BigInteger
        TypeToken<?> valueTypeToken = mapToken.resolveType(Map.class.getTypeParameters()[1]);
        System.out.println("valueTypeToken:" + valueTypeToken.getType());
        System.out.println();
    }

    /**
     * 构造带两个类型参数的TypeToken
     *
     * @param keyToken
     * @param valueToken
     * @param <K>
     * @param <V>
     * @return
     */
    <K, V> TypeToken<Map<K, V>> mapToken(TypeToken<K> keyToken, TypeToken<V> valueToken) {
        return new TypeToken<Map<K, V>>() {
        }
                .where(new TypeParameter<K>() {
                }, keyToken)
                .where(new TypeParameter<V>() {
                }, valueToken);
    }

    private void demo3() {
        TypeToken<List<Integer>> integerListToken = new TypeToken<List<Integer>>() {
        };
        TypeToken<List<? extends Number>> numberTypeToken = new TypeToken<List<? extends Number>>() {
        };
        Assert.isTrue(integerListToken.isSubtypeOf(numberTypeToken));

        System.out.println();
    }

    private void demo4() {
        ParametrizedClass<String> parametrizedClass = new ParametrizedClass<String>() {
        };

        Assert.isTrue(parametrizedClass.type.equals(TypeToken.of(String.class)), "类型参数是String");

        System.out.println();
    }

    /**
     * 这个类有类型参数 通过 TypeToken来在运行时获取其类型参数
     *
     * @param <T>
     */
    abstract class ParametrizedClass<T> {
        TypeToken<T> type = new TypeToken<T>(getClass()) {
        };
    }
}
