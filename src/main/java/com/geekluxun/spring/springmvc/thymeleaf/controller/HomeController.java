package com.geekluxun.spring.springmvc.thymeleaf.controller;

import com.geekluxun.spring.springmvc.thymeleaf.entity.Product;
import com.geekluxun.spring.springmvc.thymeleaf.entity.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-31 10:24
 * @Description:
 * @Other:
 */
public class HomeController {
    private static final String PATH1 = "test1";
    private static final String PATH2 = "test2";
    private static final int PRODUCT_COUNT = 5;

    public void process(String templateName,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        ServletContext servletContext,
                        TemplateEngine templateEngine) {
        // 创建上下文
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());


        // 设置页面上需要渲染的数据
        String servlePath = request.getServletPath();
        if (servlePath.endsWith(PATH1)) {
            setPageData1(request, ctx);
        } else if (servlePath.endsWith(PATH2)) {
            setPageData2(request, ctx);
        }
        try {
            // 响应结果写入response中
            templateEngine.process(templateName, ctx, response.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPageData1(HttpServletRequest request, WebContext ctx) {
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
    }

    private void setPageData2(HttpServletRequest request, WebContext ctx) {
        List<Product> products = new ArrayList<>();
        List<String> comments = new ArrayList<>();
        comments.add("dd");
        for (int i = 0; i < PRODUCT_COUNT; i++) {
            Product product = new Product();
            product.setInStock(false);
            product.setName("apple" + i);
            product.setPrice((i + 1) * 10);
            product.setComments(comments);
            products.add(product);
        }

        ctx.setVariable("prods", products);
    }
}
