package com.geekluxun.component.httpclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-11 19:45
 * @Description:
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientDemoTest {
    @Autowired
    HttpClientDemo httpClientDemo;

    @Test
    public void demo1() throws Exception {
        httpClientDemo.demo1();
    }

}