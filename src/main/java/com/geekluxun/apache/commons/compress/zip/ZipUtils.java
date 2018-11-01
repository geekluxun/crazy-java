package com.geekluxun.apache.commons.compress.zip;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import java.io.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 17:00
 * @Description: apache commons compress 实现的zip压缩解压缩
 * @Other:
 */
public class ZipUtils {
    /**
     * @param srcFilePath
     * @param zipFilePath
     */
    public static void zip(String srcFilePath, String zipFilePath) {

        ZipArchiveOutputStream zaos = null;
        File zipFile = new File(zipFilePath);
        if (zipFile.exists()) {
            zipFile.delete();
        }
        File srcfile = new File(srcFilePath);
        String rootSrcFilePath = srcfile.getPath() + File.separator;
        try {
            zaos = new ZipArchiveOutputStream(zipFile);
            zaos.setUseZip64(Zip64Mode.AsNeeded);
            zipLogic(srcfile, zaos, rootSrcFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (zaos != null) {
                    zaos.finish();
                    zaos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 递归压缩文件
     *
     * @param srcFile
     * @param zaos
     * @param rootFilePath
     */
    private static void zipLogic(File srcFile, ZipArchiveOutputStream zaos, String rootFilePath) {
        try {
            File[] files = srcFile.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    //  得到相对此root文件夹的路径
                    String entryName = f.getPath().substring(rootFilePath.length());
                    ZipArchiveEntry entry = new ZipArchiveEntry(f, entryName);
                    zaos.putArchiveEntry(entry);
                    zaos.closeArchiveEntry();
                    zipLogic(f, zaos, rootFilePath);
                } else {
                    if (f != null) {
                        //  得到相对此root文件夹的路径
                        String entryName = f.getPath().substring(rootFilePath.length());
                        ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(f, entryName);
                        zaos.putArchiveEntry(zipArchiveEntry);
                        InputStream is = null;
                        try {
                            is = new BufferedInputStream(new FileInputStream(f));
                            byte[] buffer = new byte[1024];
                            int len = -1;
                            while ((len = is.read(buffer)) != -1) {
                                zaos.write(buffer, 0, len);
                            }
                            zaos.closeArchiveEntry();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        } finally {
                            if (is != null)
                                is.close();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把zip文件解压到指定的文件夹
     *
     * @param zipFilePath
     * @param saveFileDir
     */
    public static void unzip(String zipFilePath, String saveFileDir) {
        if (!saveFileDir.endsWith("\\") && !saveFileDir.endsWith("/")) {
            saveFileDir += File.separator;
        }
        File dir = new File(saveFileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(zipFilePath);
        if (file.exists()) {
            InputStream is = null;
            ZipArchiveInputStream zais = null;
            try {
                is = new FileInputStream(file);
                zais = new ZipArchiveInputStream(is);
                ArchiveEntry archiveEntry = null;
                while ((archiveEntry = zais.getNextEntry()) != null) {
                    // 获取文件名
                    String entryFileName = archiveEntry.getName();
                    // 构造解压出来的文件存放路径
                    String entryFilePath = saveFileDir + entryFileName;
                    OutputStream os = null;
                    try {
                        // 把解压出来的文件写到指定路径
                        File entryFile = new File(entryFilePath);
                        if (entryFileName.endsWith("/")) {
                            entryFile.mkdirs();
                        } else {
                            os = new BufferedOutputStream(new FileOutputStream(entryFile));
                            byte[] buffer = new byte[1024];
                            int len = -1;
                            while ((len = zais.read(buffer)) != -1) {
                                os.write(buffer, 0, len);
                            }
                        }
                    } catch (IOException e) {
                        throw new IOException(e);
                    } finally {
                        if (os != null) {
                            os.flush();
                            os.close();
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (zais != null) {
                        zais.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}