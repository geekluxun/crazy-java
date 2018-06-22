package com.geekluxun.service.jdk.signature;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-22 13:40
 * @Description:
 * @Other:
 */
public interface SignatureServcie {

    String sign(String inputStr);

    Boolean verifySign(String inputStr, String signStr);
}