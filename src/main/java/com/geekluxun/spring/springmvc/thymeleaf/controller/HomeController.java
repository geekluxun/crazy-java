package com.geekluxun.spring.springmvc.thymeleaf.controller;

import com.geekluxun.spring.springmvc.thymeleaf.entity.Product;
import com.geekluxun.spring.springmvc.thymeleaf.entity.User;
import org.apache.commons.io.LineIterator;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-31 10:24
 * @Description:
 * @Other:
 */
public class HomeController implements IGTVGController{
    @Override
    public void process(HttpServletRequest request, 
                        HttpServletResponse response,
                        ServletContext servletContext, 
                        TemplateEngine templateEngine) {
        // 创建上下文
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        ctx.setVariable("today", dateFormat.format(cal.getTime()));
        // 设置会话属性
        request.getSession().setAttribute("name", "lulu");
        User user = new User();
        user.setFirstName("lu");
        user.setLastName("xun");
        user.setNationality("china");
        request.getSession().setAttribute("user", user);
        ctx.setVariable("id", 123);
        ctx.setVariable("execMode", "dev");
        ctx.setVariable("cssStyle", "warn");
        ctx.setVariable("active", false);
        
        try {
            // 响应结果写入response中
            templateEngine.process("home", ctx, response.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void process2(HttpServletRequest request,
                        HttpServletResponse response,
                        ServletContext servletContext,
                        TemplateEngine templateEngine) {
        // 创建上下文
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Product product = new Product();
            product.setInStock(false);
            product.setName("apple" + i);
            product.setPrice((i+1)*10);
            products.add(product);
        }
        
        ctx.setVariable("prods", products);
        try {
            // 响应结果写入response中
            templateEngine.process("list", ctx, response.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
}
