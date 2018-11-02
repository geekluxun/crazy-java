package com.geekluxun.jdk.security;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: luxun
 * @Create: 2018-11-01 16:15
 * @Description: 文件的加解密
 * @Other:
 */
public class FileEncrypterDecrypter {
    private SecretKey secretKey;
    private Cipher cipher;

    public static void main(String[] argc){

    }

    public FileEncrypterDecrypter(SecretKey secretKey, String cipher) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.secretKey = secretKey;
        this.cipher = Cipher.getInstance(cipher);
    }


    /**
     * 加密文件
     * @param content
     * @param encFileName
     */
    public void encrypt(String content, String encFileName) throws IOException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] iv = cipher.getIV();

        // try with resources结构 避免finally关闭IO资源问题
        try ( FileOutputStream fileOut = new FileOutputStream(encFileName);
              CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher)
            ) {
            fileOut.write(iv);
            cipherOut.write(content.getBytes());
        }
    }

    /**
     * 解密文件
     * @param encFileName
     * @return
     */
    public String decrypt(String encFileName){


        return "";
    }
}
