package com.geekluxun.util;


/**
 * @Author: luxun
 * @Create: 2018-06-23 11:48
 * @Description: 数值型工具类
 * @Other:
 */
public class NumberUtils {

    /**
     * 字节数组转换成16进制字符串（不带前缀'0x'）
     *
     * @param data
     * @return
     */
    public static String byte2HexStr(byte[] data) {
        StringBuilder hexStr = new StringBuilder();
        String hex;
        for (int i = 0; i < data.length; i++) {
            hex = (Integer.toHexString(data[i] & 0xFF));
            if (hex.length() == 1) {
                hexStr.append("0");
                hexStr.append(hex);
            } else {
                hexStr.append(hex);
            }
        }
        return hexStr.toString().toUpperCase();
    }
}
