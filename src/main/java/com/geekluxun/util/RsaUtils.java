package com.geekluxun.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @Author: luxun
 * @Create: 2018-06-23 12:16
 * @Description: 数字签名工具类
 * @Other:
 */
public class RsaUtils {
    private static final Logger logger = LoggerFactory.getLogger(RsaUtils.class);
    /**
     * 数字签名 密钥算法
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 数字签名 签名/验证算法
     */
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    /**
     * 公钥
     */
    private static PublicKey publicKey;
    /**
     * 私钥
     */
    private static PrivateKey privateKey;
    private static String publickeyFilePath = "/data/config/keys/pbkey.key";
    private static String privatekeyFilePath = "/data/config/keys/prkey.key";

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        publicKey = initPublicKey(publickeyFilePath);
        privateKey = initPirvateKey(privatekeyFilePath);
    }

    /**
     * 对原始数据进行签名（RSA2）
     * @param inputStr
     * @return
     */
    public static String sign(String inputStr) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM, "BC");
            // 使用私钥签名
            signature.initSign(privateKey);
            signature.update(inputStr.getBytes("UTF-8"));
            byte[] signed = signature.sign();
            return Base64.getEncoder().encodeToString(signed);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验证签名
     * @param inputStr
     * @param signStr
     * @return
     */
    public static Boolean verifySign(String inputStr, String signStr){
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM, "BC");
            // 使用公钥验签
            signature.initVerify(publicKey);
            signature.update(inputStr.getBytes("UTF-8"));
            byte[] data = Base64.getDecoder().decode(signStr);
            return signature.verify(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 使用公钥加密
     * @param data
     * @return
     */
    public static byte[] encryptByPublicKey(byte[] data) throws Exception{
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用私钥加密
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data)throws Exception{
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用公钥解密
     * @param data
     * @return
     */
    public static byte[] decryptByPublicKey(byte[] data) throws Exception{
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用私钥解密
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data)throws Exception{
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }


    /**
     * 初始化公钥
     * @param publickeyFilePath
     * @return
     */
    private static PublicKey initPublicKey(String publickeyFilePath){
        PublicKey publicKey = null;
        File file = new File(publickeyFilePath);
        if (file == null){
            logger.error("========打开本地公钥文件失败=======" + publickeyFilePath);
            return publicKey;
        }
        byte[] data = FileUtils.readFile(file);
        try {
            KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(data));
            publicKey = kf.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return publicKey;
    }

    /**
     *  初始化私钥
     * @param privatekeyFilePath
     * @return
     */
    private static PrivateKey initPirvateKey(String privatekeyFilePath){
        PrivateKey privateKey = null;
        File file = new File(privatekeyFilePath);
        if (file == null){
            logger.error("========打开本地私钥文件失败=======" + privatekeyFilePath);
            return privateKey;
        }
        byte[] base64 = FileUtils.readFile(file);
        try {
            KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
            byte[] data = Base64.getDecoder().decode(base64);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(data);
            privateKey = kf.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

}
