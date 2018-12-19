package com.geekluxun.component.activiti.listener.execution;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-19 10:02
 * @Description:
 * @Other:
 */
@Slf4j
public class DefaultExecuteListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {

        switch (delegateExecution.getEventName()) {
            case EVENTNAME_START: {
                log.info("======任务执行开始======" + delegateExecution.getCurrentActivityId());
                break;
            }
            case EVENTNAME_TAKE: {
                log.info("======任务领取======" + delegateExecution.getCurrentActivityId());
                break;
            }
            case EVENTNAME_END: {
                log.info("======任务执行结束======" + delegateExecution.getCurrentActivityId());
                break;
            }
            default: {
                log.info("======任务其他执行状态======" + delegateExecution.getCurrentActivityId());
                break;
            }
        }

    }
}
