package com.geekluxun.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base64;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 9:01
 * @Description:
 * @Other:
 */
public class Base64Demo {
    public static void main(String[] argc) {
        Base64Demo demo = new Base64Demo();
        demo.demo1();
    }

    private void demo1() {
        byte[] value = "luxunfa发斯蒂芬鲁鲁s341aafa1115245afa-==!!fsd@#12".getBytes();
        byte[] encoded = Base64.encodeBase64(value);
        // 每76个字符会加\r\n
        encoded = Base64.encodeBase64(value, true);
        String encodedStr = new String(encoded);
        // URL安全 '+' 改成'-' ，'/' 改成'_'  另外注意没有了填充字符'='
        encoded = Base64.encodeBase64(value, false, true);
        encodedStr = new String(encoded);
        String encodeStr2 = Base64.encodeBase64String(value);
        // 是否是base64编码 
        boolean resutl = Base64.isBase64(encodeStr2);

        System.out.println();
    }
}
