package com.geekluxun.jdk.util.zip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-06-01
 * @Description:
 * @Others:
 */
@Service
public class ZipServiceImpl implements ZipService {

    private static final Logger loggger = LoggerFactory.getLogger(ZipServiceImpl.class);

    private static final int ONE_READ_MAX_LEN = 1024;
    private static final int ONE_READ_OFFSET = 0;

    @Override
    public boolean zipCompress(String[] srcFiles, String desFile) {
        boolean isSuccessful = false;

        String[] fileNames = new String[srcFiles.length];
        for (int i = 0; i < srcFiles.length; i++) {
            fileNames[i] = parse(srcFiles[i]);
        }

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));
            ZipOutputStream zos = new ZipOutputStream(bos);
            String entryName;

            for (int i = 0; i < fileNames.length; i++) {
                entryName = fileNames[i];

                // 创建Zip条目
                ZipEntry entry = new ZipEntry(entryName);
                zos.putNextEntry(entry);

                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFiles[i]));

                byte[] b = new byte[ONE_READ_MAX_LEN];
                int count;
                while ((count = bis.read(b, ONE_READ_OFFSET, ONE_READ_MAX_LEN)) != -1) {
                    zos.write(b, ONE_READ_OFFSET, count);
                }
                bis.close();
                zos.closeEntry();
            }

            zos.flush();
            zos.close();
            isSuccessful = true;
        } catch (IOException e) {
            loggger.error("=========压缩文件失败=======", e);
        }

        return isSuccessful;
    }

    /**
     * 解析文件名
     *
     * @param srcFile
     * @return
     */
    private String parse(String srcFile) {
        // 此处有一个问题 windows下文件路径是'\' unix是'/' 现在默认是在unix 有好的办法？
        int location = srcFile.lastIndexOf("/");
        String fileName = srcFile.substring(location + 1);
        return fileName;
    }

}
