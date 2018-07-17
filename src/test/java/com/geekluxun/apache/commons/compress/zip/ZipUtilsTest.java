package com.geekluxun.apache.commons.compress.zip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 17:28
 * @Description:
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipUtilsTest {

    /**
     * 压缩
     *
     * @throws Exception
     */
    @Test
    public void zip() throws Exception {
        ZipUtils.zip("/tmp", "tmp.zip");
    }

    /**
     * 解压缩
     * @throws Exception
     */
    @Test
    public void unzip() throws Exception {
        ZipUtils.unzip("tmp.zip", File.separator + "dd");
    }

}