package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @Author: luxun
 * @Create: 2018-07-07 9:55
 * @Description:
 * @Other:
 */
public class ArrayUtilsDemo {
    public static void main(String[] argc) {
        ArrayUtilsDemo demo = new ArrayUtilsDemo();
        demo.demo1();
    }

    private void demo1() {
        boolean[] booleans = new boolean[]{};
        // 返回的是新数组（数组长度加1）
        booleans = ArrayUtils.add(booleans, true);
        booleans = ArrayUtils.add(booleans, false);
        booleans = ArrayUtils.add(booleans, false);

        long[] longs = ArrayUtils.addAll(new long[]{}, 1, 2, 3);
        longs = ArrayUtils.addAll(longs, new long[]{4, 5});

        // 拷贝
        char[] newChar = ArrayUtils.clone(new char[]{'a', 'b', 'c', 'b'});
        boolean result = ArrayUtils.contains(newChar, 'b');
        String[] strings = null;
        // 对于null数组，返回-1
        int index = ArrayUtils.indexOf(strings, 1);

        strings = ArrayUtils.insert(0, new String[]{}, "luuxn");

        result = ArrayUtils.isEmpty(new double[]{});
        // 检查是否按照自然顺序
        result = ArrayUtils.isSorted(newChar);

        // null to emtpy
        Double[] doubles = null;
        doubles = ArrayUtils.nullToEmpty(doubles);

        newChar = ArrayUtils.remove(newChar, 2);
        // 删除指定index位置
        ArrayUtils.removeAll(newChar, 1, 2);
        // 删除掉所有d
        ArrayUtils.removeAllOccurences(newChar, 'd');

        // 删除第1个
        ArrayUtils.removeElement(newChar, 'd');

        int[] newint = new int[]{1, 2, 3, 4, 5, 6};
        // 随机颠倒顺序
        ArrayUtils.shuffle(newint);
        // 转换成对象
        Integer[] newInteger = ArrayUtils.toObject(newint);

        byte[] dd = ArrayUtils.toPrimitive(new Byte[]{});
        System.out.println();

    }
}
