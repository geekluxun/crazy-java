package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharSetUtils;

/**
 * @Author: luxun
 * @Create: 2018-07-07 14:56
 * @Description:
 * @Other:
 */
public class CharSetDemo {
    public static void main(String[] argc) {
        CharSetDemo demo = new CharSetDemo();
        demo.demo1();
    }

    private void demo1() {
        CharSet charSet = CharSet.ASCII_ALPHA;
        boolean result = charSet.contains('a');
        result = CharSetUtils.containsAny("luxun", "xyz");

        int count = CharSetUtils.count("luxun", "a-z");
        String cc = CharSetUtils.delete("hello", "le");
        cc = CharSetUtils.keep("hello", "hl");
        // 挤压重复值
        cc = CharSetUtils.squeeze("hello", "k-p");
        System.out.println();
    }
}