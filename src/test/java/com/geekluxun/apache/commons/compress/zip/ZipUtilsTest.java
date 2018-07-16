package com.geekluxun.apache.commons.compress.zip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-16 17:28
 * @Description:
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipUtilsTest {
    
    @Test
    public void zip() throws Exception {
        ZipUtils.zip("/tmp", "tmp.zip");
    }

    @Test
    public void zip1() throws Exception {
        ZipUtils.zipDir("/tmp", "tmp.zip");
    }

    @Test
    public void unzip() throws Exception {
    }

}