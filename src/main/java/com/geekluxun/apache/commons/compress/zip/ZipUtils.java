package com.geekluxun.apache.commons.compress.zip;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 17:00
 * @Description:
 * @Other:
 */
public class ZipUtils {

    /**
     * 把文件压缩成zip格式
     *
     * @param srcfilesPath
     * @param zipFilePath
     */
    public static void zip(String[] srcfilesPath, String zipFilePath) {
        if (srcfilesPath == null || srcfilesPath.length <= 0) {
            return;
        }
        ZipArchiveOutputStream zaos = null;
        try {
            File zipFile = new File(zipFilePath);
            zaos = new ZipArchiveOutputStream(zipFile);
            zaos.setUseZip64(Zip64Mode.AsNeeded);
            // 将每个文件用ZipArchiveEntry封装
            // 再用ZipArchiveOutputStream写到压缩文件中
            for (String strfile : srcfilesPath) {
                File file = new File(strfile);
                if (file != null) {
                    ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(file, file.getName());
                    zaos.putArchiveEntry(zipArchiveEntry);
                    // TODO 逻辑不对！！！
                    if (file.isDirectory()) {
                        zaos.putArchiveEntry(new ZipArchiveEntry(file.getName()));
                        zaos.closeArchiveEntry();
                        continue;
                    }
                    InputStream is = null;
                    try {
                        is = new BufferedInputStream(new FileInputStream(file));
                        byte[] buffer = new byte[1024];
                        int len = -1;
                        while ((len = is.read(buffer)) != -1) {
                            // 把缓冲区的字节写入到ZipArchiveEntry
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
            zaos.finish();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (zaos != null) {
                    zaos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * @param srcDirPath
     * @param zipFilePath
     */
    public static void zip(String srcDirPath, String zipFilePath) {
            
        ZipArchiveOutputStream zaos = null;
        File zipFile = new File(zipFilePath);
        try {
            zaos = new ZipArchiveOutputStream(zipFile);
            zaos.setUseZip64(Zip64Mode.AsNeeded);
            ziplogic(srcDirPath, zaos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
                try {
                    if (zaos != null) {
                        zaos.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        
    }
    
    public static void zipDir(String srcDir, String zipFilePath){
        ZipArchiveOutputStream zaos = null;
        File zipFile = new File(zipFilePath);
        try {
            zaos = new ZipArchiveOutputStream(zipFile);
            File file = new File(srcDir);
            zaos.setUseZip64(Zip64Mode.AsNeeded);
            ZipArchiveEntry entry = new ZipArchiveEntry(file, file.getName());
            zaos.putArchiveEntry(entry);
            zaos.closeArchiveEntry();
            zaos.flush();
            zaos.finish();
            zaos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void ziplogic(String srcFilePath, ZipArchiveOutputStream zaos){
        try {
            File srcfile = new File(srcFilePath);
            File[] files = srcfile.listFiles();
            for (File f : files){
                if (f.isDirectory()){
                    
                    ziplogic(f.getPath(), zaos);
                } else {
                    if (f != null) {
                        ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(f, f.getName());
                        zaos.putArchiveEntry(zipArchiveEntry);
                        InputStream is = null;
                        try {
                            is = new BufferedInputStream(new FileInputStream(f));
                            byte[] buffer = new byte[1024];
                            int len = -1;
                            while ((len = is.read(buffer)) != -1) {
                                // 把缓冲区的字节写入到ZipArchiveEntry
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
                            os = new BufferedOutputStream(new FileOutputStream(
                                    entryFile));
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

    /**
     * 递归取到当前目录所有文件
     *
     * @param dir
     * @return
     */
    private static List<String> getFiles(String dir) {
        List<String> lstFiles = null;
        if (lstFiles == null) {
            lstFiles = new ArrayList<>();
        }
        File file = new File(dir);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                lstFiles.add(f.getAbsolutePath());
                lstFiles.addAll(getFiles(f.getAbsolutePath()));
            } else {
                String str = f.getAbsolutePath();
                lstFiles.add(str);
            }
        }
        return lstFiles;
    }
}