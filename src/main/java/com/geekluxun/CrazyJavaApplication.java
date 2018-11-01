package com.geekluxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-06-21 10:55
 * @Description:
 * @Other:
 */
@SpringBootApplication
public class CrazyJavaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CrazyJavaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CrazyJavaApplication.class, args);
    }
}
