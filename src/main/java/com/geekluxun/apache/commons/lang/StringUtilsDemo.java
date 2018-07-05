package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-05 16:40
 * @Description:
 * @Other:
 */
public class StringUtilsDemo {
    public static void main(){
        StringUtilsDemo demo = new StringUtilsDemo();
        demo.demo1();
    }
    
    
    private void demo1(){
        String str = "luxun";
        StringUtils.containsAny(str, 'a', 'b', 'c');
    }
}
