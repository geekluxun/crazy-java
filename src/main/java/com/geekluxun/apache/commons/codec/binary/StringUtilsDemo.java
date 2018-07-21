package com.geekluxun.apache.commons.codec.binary;


import org.apache.commons.codec.binary.StringUtils;

import javax.print.DocFlavor;
import java.nio.ByteBuffer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 10:26
 * @Description:
 * @Other:
 */
public class StringUtilsDemo {
    public static void main(String[] argc){
        StringUtilsDemo demo = new StringUtilsDemo();
        demo.demo1();
    }
    
    
    private void demo1(){
        ByteBuffer data = StringUtils.getByteBufferUtf8("luxun");
        byte[] data2 = StringUtils.getBytesUtf8("luxun");
        data2 = StringUtils.getBytesIso8859_1("luxun");
        data2  = StringUtils.getBytesUsAscii("鲁");
        data2  = StringUtils.getBytesUtf16("luxun");
        data2 = StringUtils.getBytesUtf16Le("luxun");
        data2 = StringUtils.getBytesUtf16Be("luxun");
        System.out.println();
    }
}

