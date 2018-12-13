package com.geekluxun.component.activiti.listener.task;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-13 11:33
 * @Description:
 * @Other:
 */
@Slf4j
public class DefaultExecuteListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        log.info("======DefaultExecuteListener======EventName:" + delegateExecution.getEventName() 
                + " CurrentActivityId:" + delegateExecution.getCurrentActivityId());
        delegateExecution.setVariable("result", "luxun");
        
    }
}
