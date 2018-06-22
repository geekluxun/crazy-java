package com.geekluxun;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
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
    public void testJSONlog(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", 1);
        jsonObject.put("key2", "luxun");
        jsonObject.put("key3", 3.3f);
        
        System.out.println("print jsonobject:" + jsonObject);
    }
}
