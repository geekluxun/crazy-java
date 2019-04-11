package com.geekluxun.component.activiti.listener.execution;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import java.util.HashMap;
import java.util.Map;

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
    public void notify(DelegateExecution delegateExecution) {
        log.info("当前执行任务所有信息：" + getExecutionInfo(delegateExecution));
        //delegateExecution.getEngineServices().getTaskService();
        switch (delegateExecution.getEventName()) {
            case EVENTNAME_START: {
                log.info("======执行任务开始======" + delegateExecution.getCurrentActivityId());
                break;
            }
            case EVENTNAME_TAKE: {
                log.info("======执行任务take======" + delegateExecution.getCurrentActivityId());
                break;
            }
            case EVENTNAME_END: {
                log.info("======执行任务结束======" + delegateExecution.getCurrentActivityId());
                break;
            }
            default: {
                log.info("======执行任务其他状态======" + delegateExecution.getCurrentActivityId());
                break;
            }
        }
    }

    /**
     * 获取执行相关信息
     *
     * @param execution
     * @return
     */
    private Map getExecutionInfo(DelegateExecution execution) {
        Map paras = new HashMap();
        paras.put("CurrentActivityId", execution.getCurrentActivityId());
        paras.put("ExecutionId:", execution.getId());
        paras.put("CurrentFlowElement", execution.getCurrentFlowElement());
        paras.put("EventName", execution.getEventName());
        paras.put("loadApplyId", execution.getVariable("loadApplyId"));
        return paras;
    }
}
