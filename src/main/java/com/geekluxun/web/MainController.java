package com.geekluxun.web;

import com.geekluxun.component.httpclient.HttpClientDemo;
import com.geekluxun.component.sevlet.HttpSevletDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: luxun
 * @Create: 2018-07-02 20:59
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    HttpClientDemo httpClientDemo;
    @Autowired
    HttpSevletDemo httpSevletDemo;


    /**
     * 测试servlet容器在系统中的路径
     *
     * @param request
     * @param response
     */
    @GetMapping("/test1")
    public void test(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getRealPath("/dd");
        System.out.println(path);
    }

    /**
     * 注意此处加参数response和不加参数response是不同的
     * 不加的话会500报错，方法的返回值也是用来设置此response的
     *
     * @param response
     */
    @GetMapping("/test2")
    public Object testHttpClient(HttpServletRequest request, HttpServletResponse response) {
        httpClientDemo.demo1();
        response.setContentType("dd");
        httpSevletDemo.demo1(request);
        httpSevletDemo.demo2(request);
        // 或者用这种方法
        return new ResponseEntity("hello", HttpStatus.OK);
    }
}


