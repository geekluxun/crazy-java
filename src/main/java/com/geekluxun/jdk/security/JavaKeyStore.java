package com.geekluxun.jdk.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;

/**
 * @Author: luxun
 * @Create: 2018-11-07 14:53
 * @Description: KeyStore示例
 * @Other:
 */
public class JavaKeyStore {

    private KeyStore keyStore;

    private String keyStoreName;
    private String keyStoreType;
    private String keyStorePassword;

    JavaKeyStore(String keyStoreType, String keyStorePassword, String keyStoreName) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.keyStoreName = keyStoreName;
        this.keyStoreType = keyStoreType;
        this.keyStorePassword = keyStorePassword;
    }

    void createEmptyKeyStore() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        if(keyStoreType ==null || keyStoreType.isEmpty()){
            keyStoreType = KeyStore.getDefaultType();
        }
        keyStore = KeyStore.getInstance(keyStoreType);
        //load
        char[] pwdArray = keyStorePassword.toCharArray();
        keyStore.load(null, pwdArray);

        // Save the keyStore
        FileOutputStream fos = new FileOutputStream(keyStoreName);
        keyStore.store(fos, pwdArray);
        fos.close();
    }

    /**
     * 从文件中加载keystore(keystore本身通过密码保护)
     * @throws IOException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     */
    void loadKeyStore() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
        char[] pwdArray = keyStorePassword.toCharArray();
        keyStore.load(new FileInputStream(keyStoreName), pwdArray);
    }

    /**
     * 设置对称密钥条目
     * @param alias
     * @param secretKeyEntry
     * @param protectionParameter
     * @throws KeyStoreException
     */
    void setEntry(String alias, KeyStore.SecretKeyEntry secretKeyEntry, KeyStore.ProtectionParameter protectionParameter) throws KeyStoreException {
        keyStore.setEntry(alias, secretKeyEntry, protectionParameter);
    }

    KeyStore.Entry getEntry(String alias) throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException {
        // 保护参数可以用于检查 keystore 数据的完整性，或用于保护敏感的 keystore 数据（例如，PrivateKey）的机密性
        KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(keyStorePassword.toCharArray());
        return keyStore.getEntry(alias, protParam);
    }

    /**
     * 设置非对称的私钥 条目
     * @param alias
     * @param privateKey
     * @param keyPassword
     * @param certificateChain
     * @throws KeyStoreException
     */
    void setKeyEntry(String alias, PrivateKey privateKey, String keyPassword, Certificate[] certificateChain) throws KeyStoreException {
        keyStore.setKeyEntry(alias, privateKey, keyPassword.toCharArray(), certificateChain);
    }

    /**
     * 设置证书条目
     * @param alias
     * @param certificate
     * @throws KeyStoreException
     */
    void setCertificateEntry(String alias, Certificate certificate) throws KeyStoreException {
        keyStore.setCertificateEntry(alias, certificate);
    }

    Certificate getCertificate(String alias) throws KeyStoreException {
        return keyStore.getCertificate(alias);
    }

    void deleteEntry(String alias) throws KeyStoreException {
        keyStore.deleteEntry(alias);
    }

    /**
     * 删除keystore中所有条目
     * @throws KeyStoreException
     * @throws IOException
     */
    void deleteKeyStore() throws KeyStoreException, IOException {
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            keyStore.deleteEntry(alias);
        }
        keyStore = null;
        Files.delete(Paths.get(keyStoreName));
    }

    KeyStore getKeyStore() {
        return this.keyStore;
    }
}
