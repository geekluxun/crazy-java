package com.geekluxun.apache.commons.io;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-18 9:58
 * @Description:
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IOUtilsDemoTest {
    @Autowired
    IOUtilsDemo demo;

    @Test
    public void demo2() throws Exception {
        demo.demo2();
    }

}