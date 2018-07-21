package com.geekluxun.apache.commons.codec.digest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 10:37
 * @Description:
 * @Other:
 */
public class DigestUtilsDemo {
    public static void main(String[] argc ){
        DigestUtilsDemo demo = new DigestUtilsDemo();
        demo.demo1();
        demo.demo2();
    }

    /**
     * MD5
     */
    private void demo1(){
        byte[] md5value2 = DigestUtils.md5("luxun");
        // 当前类所有的绝对路径
        URL url = getClass().getResource("DigestUtilsDemo.class");
        // 类名转化成path
        String path = ClassUtils.convertClassNameToResourcePath(getClass().getName());
        // classpath所在的绝对路径
        // url = getClass().getResource("/");
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(path + ".class");
        String md5value3;
        try {
            // 输入流生成md5
            md5value3 = DigestUtils.md5Hex(inputStream);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String md5value = DigestUtils.md5Hex("luxun");
        md5value = md5value.toUpperCase();
        System.out.println();
    }

    /**
     * SHA
     */
    private void demo2(){
        // 20byte 160bit
        String sha = DigestUtils.sha1Hex("luxun");
        // 32byte 256bit
        sha = DigestUtils.sha256Hex("luxun");
        // 48byte 384bit
        sha = DigestUtils.sha384Hex("luxun");
        System.out.println();
    }
}
