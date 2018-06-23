package com.geekluxun.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: luxun
 * @Create: 2018-06-23 11:25
 * @Description:
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DigestUtilsTest {
    @Test
    public void md5() throws Exception {
        String md5 = DigestUtils.md5Str("luxun".getBytes("UTF-8"));
        System.out.println("md5value:" + md5);
        Assert.assertTrue(md5.length() == 16*2);
        String sha = DigestUtils.sha("luxun".getBytes("UTF-8"));
        System.out.println("shavalue:" + sha);
        Assert.assertTrue(sha.length() == 20*2);

        String sha256 = DigestUtils.sha256("luxun".getBytes("UTF-8"));
        System.out.println("sha256value:" + sha256);
        Assert.assertTrue(sha256.length() == 32*2);
    }
}