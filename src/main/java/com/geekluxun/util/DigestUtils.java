package com.geekluxun.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: luxun
 * @Create: 2018-06-23 11:16
 * @Description: 消息摘要工具类
 * @Other:
 */
public class DigestUtils {

    /**
     * 生成MD5消息摘要
     *
     * @param input
     * @return 16字节数组转换成16进制字符串形式输出
     */
    public static String md5Str(byte[] input) {
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            md5Digest.update(input);
            byte[] md5 = md5Digest.digest();
            return NumberUtils.byte2HexStr(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成MD5消息摘要
     *
     * @param input
     * @return 16字节数组
     */
    public static byte[] md5(byte[] input) {
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            md5Digest.update(input);
            byte[] md5 = md5Digest.digest();
            return md5;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成SHA1消息摘要
     *
     * @param input
     * @return 20字节转换成16进制字符串形式输出
     */
    public static String sha(byte[] input) {
        try {
            MessageDigest shaDigest = MessageDigest.getInstance("SHA");
            shaDigest.update(input);
            byte[] sha = shaDigest.digest();
            return NumberUtils.byte2HexStr(sha);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成SHA2(256)消息摘要
     *
     * @param input
     * @return 32字节转换成16进制字符串形式输出
     */
    public static String sha256(byte[] input) {
        try {
            MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
            shaDigest.update(input);
            byte[] sha256 = shaDigest.digest();
            return NumberUtils.byte2HexStr(sha256);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
