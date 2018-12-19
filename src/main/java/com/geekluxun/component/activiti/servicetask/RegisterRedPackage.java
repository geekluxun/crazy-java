package com.geekluxun.component.activiti.servicetask;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-13 11:17
 * @Description:
 * @Other:
 */
@Slf4j
public class RegisterRedPackage implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("======RegisterRedPackage用户注册增加红包处理======");
        delegateExecution.setVariable("age", "30");
    }
}
