package com.geekluxun.web;

import com.geekluxun.component.httpclient.HttpClientDemo;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * @Author: luxun
 * @Create: 2018-07-02 20:59
 * @Description:
 * @Other:
 */
@Controller
public class MainController {
    @Autowired
    HttpClientDemo httpClientDemo;

    /**
     * 测试servlet容器在系统中的路径
     * @param request
     * @param response
     */
    @RequestMapping("/test1")
    public void test(HttpServletRequest request, HttpServletResponse response){
        Map para = request.getParameterMap();
        Set<Map.Entry<K, String>> entries =  para.entrySet();
        for (Map.Entry map :entries){
            System.out.println("key:" + map.getKey() + " value:" + map.getValue());
        }
        //entries.forEach((a)->System.out.println("key:" + a.getKey() + " value:" + a.getValue()));
        String path = request.getServletContext().getRealPath("/dd");
        System.out.println(path);
    }

    @RequestMapping("/test2")
    public void testHttpClient(){
        httpClientDemo.demo1();
    }
    
    
}


