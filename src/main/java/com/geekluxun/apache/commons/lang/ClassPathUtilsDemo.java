package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.ClassPathUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-09 9:06
 * @Description:
 * @Other:
 */
public class ClassPathUtilsDemo {
    public static void main(String[] argc) {
        ClassPathUtilsDemo demo = new ClassPathUtilsDemo();
        demo.demo1();

    }

    private void demo1() {
        String name, path;
        try {
            name = ClassPathUtils.toFullyQualifiedName(StringUtils.class, "StringUtils.properties");
            name = ClassPathUtils.toFullyQualifiedName(StringUtils.class.getPackage(), "dd");
            path = ClassPathUtils.toFullyQualifiedPath(String.class, "luxun");
            path = ClassPathUtils.toFullyQualifiedPath(String.class.getPackage(), "luxun");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
