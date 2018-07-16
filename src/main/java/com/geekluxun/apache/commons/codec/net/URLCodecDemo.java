package com.geekluxun.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 11:15
 * @Description:
 * @Other:
 */
public class URLCodecDemo {
    public static void main(String[] argc){
        URLCodecDemo demo = new URLCodecDemo();
        demo.demo1();
    }
    
    private void demo1(){
        URLCodec urlCodec = new URLCodec();
        String urlencoded ;
        String url;
        try {
            // 编码
            urlencoded = urlCodec.encode("鲁勋");
            // URI保留字符 用百分号编码 像'/'有特殊含义的保留字符如果要出现在URI内部，必须用百分号编码
            urlencoded = urlCodec.encode("!*'();:@&=+$,/?#[]");
            // URI未保留字符 除了保留字符和未保留字符以外的任何字符必须使用百分号编码
            urlencoded = urlCodec.encode("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789	-_.~");
            // 解码
            url = urlCodec.decode(urlencoded);
            url = urlCodec.decode("%E9%9A%8F%E6%9C%BA%E9%A1%B5%E9%9D%A2");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
