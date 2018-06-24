package com.geekluxun.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Base64;

/**
 * @Author: luxun
 * @Create: 2018-06-23 12:19
 * @Description: 数字签名工具类
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RsaUtilsTest {

    /**
     * 明文数据
     */
    private static final String plainText = "luxun";

    /**
     * 签名验签
     * @throws Exception
     */
    @Test
    public void signAndVerify() throws Exception {
        String signed = RsaUtils.sign(plainText);
        Boolean result = RsaUtils.verifySign(plainText, signed);
        Assert.assertTrue(result);
    }

    /**
     * 私钥加密 公钥解密
     */
    @Test
    public void encryptAndDecrypt1(){
        try {
            byte[] encryedData = RsaUtils.encryptByPrivateKey(plainText.getBytes("UTF-8"));
            String base64 = Base64.getEncoder().encodeToString(encryedData);
            byte[] decryedData = RsaUtils.decryptByPublicKey(encryedData);
            String decryedStr = new String(decryedData);
            Assert.assertTrue(decryedStr.equals(plainText));
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    /**
     * 公钥加密 私钥解密
     */
    @Test
    public void encryptAndDecrypt2(){
        try {
            byte[] encryedData = RsaUtils.encryptByPublicKey(plainText.getBytes("UTF-8"));
            byte[] decryedData = RsaUtils.decryptByPrivateKey(encryedData);
            String decryedStr = new String(decryedData);
            Assert.assertTrue(decryedStr.equals(plainText));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成密钥对
     */
    @Test
    public void generateKey(){
        RsaUtils.generateKeyPair();
    }
}