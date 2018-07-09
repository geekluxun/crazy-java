package com.geekluxun.apache.commons.lang;

import org.apache.commons.lang3.Conversion;

import java.util.UUID;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-09 9:56
 * @Description:
 * @Other:
 */
public class ConversionDemo {
    public static void main(String[] argc){
        ConversionDemo demo = new ConversionDemo();
        demo.demo1();
    }
    
    private void demo1(){
        // 由16个字节 32个16进制字符组成（不包括4个'-'）
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        byte[] uarray = new byte[40];
        Conversion.uuidToByteArray(uuid, uarray, 0, 16);
        
        // 转换成16进制字符串
        s = Integer.toHexString(0x12345678);
        System.out.println();
    }
}
