package com.geekluxun.web;

import com.geekluxun.apache.commons.fileupload.FileUploadDemo;
import com.geekluxun.component.httpclient.HttpClientDemo;
import com.geekluxun.component.sevlet.HttpSevletDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @Autowired
    HttpSevletDemo httpSevletDemo;
    @Autowired
    FileUploadDemo fileUploadDemo;

    /**
     * 测试servlet容器在系统中的路径
     * @param request
     * @param response
     */
    @RequestMapping("/test1")
    public void test(HttpServletRequest request, HttpServletResponse response){
        String path = request.getServletContext().getRealPath("/dd");
        System.out.println(path);
    }

    /**
     * 注意此处加参数response和不加参数response是不同的
     * 不加的话会500报错，方法的返回值也是用来设置此response的
     * @param response
     */
    @RequestMapping("/test2")
    public Object testHttpClient(HttpServletRequest request, HttpServletResponse response){
        httpClientDemo.demo1();
        response.setContentType("dd");
        httpSevletDemo.demo1(request);
        httpSevletDemo.demo2(request);
        // 或者用这种方法
        return new ResponseEntity("hello",HttpStatus.OK);
    }
    
    @RequestMapping("/getuploadfile")
    public ModelAndView getUpLoadFilePage() {
        ModelAndView modelAndView = new ModelAndView("uploadfile");
        return modelAndView;
    }

    /**
     * 上传文件示例
     *
     * @param request
     */
    @RequestMapping("/uploadfile")
    public void upLoadFile(HttpServletRequest request) {
        fileUploadDemo.demo2(request);
    }
}


