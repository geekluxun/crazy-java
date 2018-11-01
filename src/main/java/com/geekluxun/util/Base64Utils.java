package com.geekluxun.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Author: luxun
 * @Create: 2018-06-23 15:51
 * @Description:
 * @Other:
 */
public class Base64Utils {

    public static String decode(String input) {
        byte[] output = Base64.getDecoder().decode(input);
        String outputStr = null;
        try {
            outputStr = new String(output, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return outputStr;
    }
}
