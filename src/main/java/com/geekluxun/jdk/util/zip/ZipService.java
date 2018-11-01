package com.geekluxun.jdk.util.zip;

/**
 * Copyright,2018-2019,geekluxunCo.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-06-01
 * @Description: zip压缩解压服务
 * @Others:
 */
public interface ZipService {
    /**
     * zip压缩
     *
     * @param srcFiles
     * @param desFile
     * @return
     */
    boolean zipCompress(String[] srcFiles, String desFile);
}
