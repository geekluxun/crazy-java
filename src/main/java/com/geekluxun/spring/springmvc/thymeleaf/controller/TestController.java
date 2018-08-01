package com.geekluxun.spring.springmvc.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-31 10:10
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/thymeleaf")
public class TestController {

    private static TemplateEngine templateEngine;
    private static ServletContext servletContext;

    @RequestMapping("/test1")
    public void test(HttpServletRequest request, HttpServletResponse response){
        servletContext = request.getServletContext();
        // 初始化模板引擎
        initializeTemplateEngine(request.getServletContext());
        // 渲染模板
        try {
            process("test1", request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/test2")
    public void test2(HttpServletRequest request, HttpServletResponse response) {
        servletContext = request.getServletContext();
        // 初始化模板引擎
        initializeTemplateEngine(request.getServletContext());
        // 渲染模板
        try {
            process("test2", request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private boolean process(String templateName, HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        try {
            
            /*
             * Query controller/URL mapping and obtain the controller
             * that will process the request. If no controller is available,
             * return false and let other filters/servlets process the request.
             */
            HomeController controller = new HomeController();
            if (controller == null) {
                return false;
            }
            
            /*
             * Write the response headers
             */
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            /*
             * Execute the controller and process view template,
             * writing the results to the response writer.
             */
            controller.process(templateName, request, response, servletContext, templateEngine);
            return true;
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    /**
     * 初始化模板引擎示例
     */
    private static void initializeTemplateEngine(ServletContext context) {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context);
        // XHTML is the default mode, but we set it anyway for better understanding of code
        templateResolver.setTemplateMode("XHTML");
        // This will convert "home" to "/WEB-INF/templates/test1.html"
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        // Template cache TTL=1h. If not set, entries would be cached until expelled by LRU
        templateResolver.setCacheTTLMs(3600000L);
        templateResolver.setCharacterEncoding("UTF-8");
        
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }
}
