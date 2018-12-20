package com.geekluxun.component.activiti.listener.task;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-19 10:07
 * @Description:
 * @Other:
 */
@Slf4j
public class DefaultTaskListener implements TaskListener {
    @Autowired
    RuntimeService runtimeService;

    @Override
    public void notify(DelegateTask delegateTask) {

        switch (delegateTask.getEventName()) {
            case EVENTNAME_CREATE: {
                log.info("======任务创建======" + delegateTask.getName());
                String loadApplyId = (String) delegateTask.getExecution().getVariable("loadApplyId");
                delegateTask.setVariableLocal("loadApplyId", loadApplyId);
                break;
            }
            case EVENTNAME_ASSIGNMENT: {
                log.info("======任务分配======" + delegateTask.getName());
                break;
            }
            case EVENTNAME_COMPLETE: {
                log.info("======任务完成======" + delegateTask.getName());
                break;
            }
            case EVENTNAME_DELETE: {
                log.info("======任务删除======" + delegateTask.getName());
                break;
            }
            default: {
                log.info("======其他任务事件======" + delegateTask.getName());
            }
        }
    }
}
