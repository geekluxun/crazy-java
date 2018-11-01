package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.EnumUtils;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-09 10:27
 * @Description:
 * @Other:
 */
public class EnumUtilsDemo {
    public static void main(String[] argc) {
        EnumUtilsDemo demo = new EnumUtilsDemo();
        demo.demo1();
    }

    private void demo1() {
        // 产生一个位向量 long 共有64bit 每一位代表一个enum值
        long value = EnumUtils.generateBitVector(Person.class, Person.WORMAN, Person.MAN);

        // 所有enum常量组成的list
        List<Person> personList = EnumUtils.getEnumList(Person.class);

        // 根据name得到 enum值
        Person person = EnumUtils.getEnum(Person.class, "MAN");
        // key= name value 是值
        Map map = EnumUtils.getEnumMap(Person.class);

        boolean valid = EnumUtils.isValidEnum(Person.class, "Man");

        EnumSet<Person> set = EnumUtils.processBitVector(Person.class, value);
        System.out.println();
    }

    private enum Person {
        MAN,
        WORMAN
    }
}
