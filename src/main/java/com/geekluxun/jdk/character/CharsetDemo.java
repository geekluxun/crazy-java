package com.geekluxun.jdk.character;

import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-29 13:32
 * @Description: 字符集示例
 * @Other:
 */
public class CharsetDemo {
    public static void main(String[] argc){
        CharsetDemo charsetDemo = new CharsetDemo();
        charsetDemo.demo1();
    }
    
    private void demo1(){
        try {
            // 默认是utf-8编码
            byte[] data = "鲁".getBytes();
            byte[] data2 = "鲁".getBytes("gb2312");
            Assert.isTrue(data.length == 3, "使用UTF-8编码是3个字节");
            Assert.isTrue(data2.length == 2, "使用GB2312编码是2个字节");
            
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 可用的字符编码集
        Map charset = Charset.availableCharsets();
        System.out.println("可用字符编码集：" + charset);
    }
}
