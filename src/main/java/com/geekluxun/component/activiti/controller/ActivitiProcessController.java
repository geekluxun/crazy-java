package com.geekluxun.component.activiti.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-13 11:04
 * @Description:
 * @Other:
 */
@RestController
@RequestMapping("/activiti/process")
public class ActivitiProcessController {

    @Autowired
    private RuntimeService runtimeService;


    @GetMapping("/start")
    public Object startMyprocess(@RequestParam("loadApplyId") String loadApplyId) {
        ProcessInstance processInstance = runtimeService
                .createProcessInstanceBuilder()
                .variable("loadApplyId", loadApplyId)
                .processDefinitionKey("myProcess_1")
                .start();
        return getProcessInstanceInfo(processInstance);
    }


    private Map getProcessInstanceInfo(ProcessInstance processInstance) {
        Map map = new HashMap();
        map.put("name", processInstance.getName());
        map.put("DeploymentId", processInstance.getDeploymentId());
        map.put("ActivityId", processInstance.getActivityId());
        map.put("ProcessInstanceId", processInstance.getProcessInstanceId());
        map.put("id", processInstance.getId());
        return map;
    }

}
