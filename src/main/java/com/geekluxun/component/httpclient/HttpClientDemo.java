package com.geekluxun.component.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-11 18:49
 * @Description:
 * @Other:
 */
@Service
public class HttpClientDemo {
    public static void main(String[] argc){
        HttpClientDemo demo = new HttpClientDemo();
        demo.demo1();
    }
    
    public void  demo1(){
        HttpPost httpPost = new HttpPost("http://localhost:8080/test1");
        httpPost.addHeader("clientId", "geekluxun");
        List<NameValuePair> form = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            NameValuePair nameValuePair = new BasicNameValuePair("key" + i, i+"luxun");
            form.add(nameValuePair);
        }
        HttpEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(form);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(entity);
        HttpClient httpClient = HttpClients.createDefault();
        try {
            httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
