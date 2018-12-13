package com.geekluxun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-13 10:59
 * @Description:
 * @Other:
 */
@Configuration
@ImportResource(locations = {"classpath*:/spring/activiti-config.xml"})
public class AppConfig {
}
