package com.geekluxun.service.jdk.signature;

import com.geekluxun.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-22 13:40
 * @Description:
 * @Other:
 */
@Service
public class SignatureServiceImpl implements SignatureServcie {
    private static final Logger logger = LoggerFactory.getLogger(SignatureServiceImpl.class);
    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static String publickeyFilePath = "/data/config/keys/pbkey.key";
    private static String privatekeyFilePath = "/data/config/keys/prkey.key";

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        publicKey = initPublicKey(publickeyFilePath);
        privateKey = initPirvateKey(privatekeyFilePath);
    }

    /**
     * 对原始数据进行签名
     * @param inputStr
     * @return
     */
    @Override
    public String sign(String inputStr) {
        try {
            Signature signature = Signature.getInstance("SHA1withRSA", "BC");
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
    @Override
    public Boolean verifySign(String inputStr, String signStr){
        try {
            Signature signature = Signature.getInstance("SHA1withRSA", "BC");
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
        byte[] data = FileUtil.readFile(file);
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
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
        byte[] data = FileUtil.readFile(file);
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            byte[] data2 = Base64.getDecoder().decode(data);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(data2);
            privateKey = kf.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }
    
}
