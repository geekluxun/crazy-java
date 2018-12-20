package com.geekluxun.component.activiti.servicetask;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-13 16:28
 * @Description:
 * @Other:
 */
@Slf4j
public class YoungMan implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.info("=====进入年轻人流程======");
    }
}
