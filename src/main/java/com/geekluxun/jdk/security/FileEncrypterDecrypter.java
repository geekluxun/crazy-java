package com.geekluxun.jdk.security;

import org.springframework.util.Assert;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
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

    public static void main(String[] argc) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        String cipher = "AES/CBC/PKCS5Padding";
        FileEncrypterDecrypter enc = new FileEncrypterDecrypter(secretKey, cipher);
        enc.encrypt("luxun", "1.txt");
        String content = enc.decrypt("1.txt");
        Assert.isTrue(content.equals("luxun"), "加密和解密内容不同");
    }

    public FileEncrypterDecrypter(SecretKey secretKey, String cipher) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.secretKey = secretKey;
        this.cipher = Cipher.getInstance(cipher);
    }


    /**
     * 加密文件
     *
     * @param content
     * @param encFileName
     */
    public void encrypt(String content, String encFileName) throws IOException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        // 初始化向量
        byte[] iv = cipher.getIV();

        // try with resources结构 避免finally关闭IO资源问题
        try (FileOutputStream fileOut = new FileOutputStream(encFileName);
             CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher)
        ) {
            fileOut.write(iv);
            cipherOut.write(content.getBytes());
        }
    }

    /**
     * 解密文件
     *
     * @param encFileName
     * @return
     */
    public String decrypt(String encFileName) throws IOException, InvalidAlgorithmParameterException, InvalidKeyException {

        String content;

        try (FileInputStream fileIn = new FileInputStream(encFileName)) {
            byte[] fileIv = new byte[16];
            fileIn.read(fileIv);
            // 初始化加密
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(fileIv));

            try (
                    CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher);
                    InputStreamReader inputReader = new InputStreamReader(cipherIn);
                    BufferedReader reader = new BufferedReader(inputReader)
            ) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                content = sb.toString();
            }

        }
        return content;
    }
}
