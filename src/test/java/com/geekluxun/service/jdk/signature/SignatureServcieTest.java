package com.geekluxun.service.jdk.signature;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-22 15:40
 * @Description:
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SignatureServcieTest {
    @Autowired
    private SignatureServcie signatureServcie;
    private String inputStr = "luxun";
    
    @Test
    public void verifySign() throws Exception {
        String signed = signatureServcie.sign(inputStr);
        Boolean result = signatureServcie.verifySign(inputStr, signed);
        Assert.assertTrue(result);
    }
}