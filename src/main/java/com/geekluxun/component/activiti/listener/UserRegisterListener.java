package com.geekluxun.component.activiti.listener;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.delegate.TaskListener;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-13 10:54
 * @Description:
 * @Other:
 */
@Slf4j
public class UserRegisterListener implements TaskListener {
    

    @Override
    public void notify(DelegateTask delegateTask) {
        log.info("======TaskListener--->UserRegisterListener======eventName:" + delegateTask.getEventName());
        delegateTask.setVariable("result", "geek");
    }
}
