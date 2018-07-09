package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.BooleanUtils;

/**
 * @Author: luxun
 * @Create: 2018-07-07 14:40
 * @Description:
 * @Other:
 */
public class BooleanUtilsDemo {
    public static void main(String[] argc){
        BooleanUtilsDemo demo = new BooleanUtilsDemo();
        demo.demo1();
    }

    private void demo1(){
        boolean result = BooleanUtils.and(new boolean[]{true, false, true});
        result = BooleanUtils.and(new Boolean[]{Boolean.TRUE, Boolean.FALSE, Boolean.TRUE});
        System.out.println(result);

        result = BooleanUtils.toBoolean(1);
        result = BooleanUtils.toBoolean("true");
        result = BooleanUtils.toBooleanObject(1);
        int boolint = BooleanUtils.toInteger(false);
        String boolString = BooleanUtils.toString(true, "yes", "no");

        System.out.println();
    }
}
