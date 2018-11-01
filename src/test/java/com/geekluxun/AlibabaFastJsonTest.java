package com.geekluxun;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-21 10:55
 * @Description: fastjson测试用例
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlibabaFastJsonTest {

    @Test
    public void testJSONlog() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", 1);
        jsonObject.put("key2", "luxun");
        jsonObject.put("key3", 3.3f);

        System.out.println("print jsonobject:" + jsonObject);
    }

    @Test
    public void testMap2JSONObject() {
        Map paras = new HashMap();
        paras.put("key1", 10);
        paras.put("key2", "luxun");
        paras.put("key3", 3.3f);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(paras);
        System.out.println("print jsonobject:" + jsonObject);
    }
}
