package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.Validate;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-10 12:32
 * @Description:
 * @Other:
 */
public class ValidateDemo  {
    public static void main(String[] argc){
        ValidateDemo demo = new ValidateDemo();
        demo.demo1();
    }
    
    private void demo1(){
        // 不包行两边值 否则抛异常
        Validate.exclusiveBetween(1, 10,3);
        // 包行
        Validate.inclusiveBetween(1, 10, 10);

        Validate.matchesPattern("hi", "[a-z]*");

        Validate.noNullElements(new String[]{});
        
        //Validate.notBlank(" ");
        Validate.notEmpty(" ");
        System.out.println();
    }
}
