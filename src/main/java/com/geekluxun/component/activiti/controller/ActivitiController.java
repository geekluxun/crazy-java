package com.geekluxun.component.activiti.controller;

import afu.org.checkerframework.checker.oigj.qual.O;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-13 11:04
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/activiti")
public class ActivitiController {

    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private TaskService taskService;
    
    
    @RequestMapping("/start")
    @ResponseBody
    public Object startMyprocess(){
        runtimeService.startProcessInstanceByKey("myProcess_1");
        Task task = taskService.createTaskQuery().singleResult();
        
        taskService.complete(task.getId());

        List<String> dd = Collections.emptyList();
        return "Ok";
    }
}
