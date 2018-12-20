package com.geekluxun.component.activiti.controller;

import com.geekluxun.common.BaseController;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-12-19 17:52
 * @Description:
 * @Other:
 */
@RestController
@RequestMapping("/activiti/task")
@Slf4j
public class ActivitiTaskController extends BaseController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/queryTaskByUserId")
    @ApiOperation(value = "根据用户id查询任务列表")
    public Object queryTaskByUserId(@RequestParam("userId") String userId) {
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(userId).list();
        log.info("用户:" + userId + "所有任务列表：");
        return getTaskInfo(taskList);
    }


    @GetMapping("/queryAllUnAssignedTasks")
    @ApiOperation(value = "查询所有未分配任务")
    public Object queryAllUnAssignedTasks() {
        List<Task> tasks = taskService.createTaskQuery().taskUnassigned().list();
        return getTaskInfo(tasks);
    }

    @GetMapping("/assignTaskByUserId")
    @ApiOperation(value = "按照用户id和任务id分配任务")
    public Object assignTaskByUserId(@RequestParam("taskId") String taskId, @RequestParam("userId") String userId) {
        taskService.setAssignee(taskId, userId);
        return "任务:" + taskId + "已分配给用户:" + userId;
    }

    @GetMapping("/executeTask")
    @ApiOperation(value = "执行任务")
    public Object executeTask(@RequestParam("taskId") String taskId, @RequestParam("userId") String userId) throws Exception {
        String loadApplyId = (String) taskService.getVariableLocal(taskId, "loadApplyId");
        log.info("执行进件号为" + loadApplyId + "的任务开始...");
        Thread.sleep(5000);
        log.info("执行进件号为" + loadApplyId + "的任务完成...");
        taskService.complete(taskId);
        return "任务执行完成";
    }


    /**
     * 显示任务信息
     *
     * @param tasks
     * @return
     */
    private List<Map> getTaskInfo(List<Task> tasks) {
        List<Map> responseList = new ArrayList<>();

        for (Task task : tasks) {
            Map response = new HashMap<>();
            response.put("assignee", task.getAssignee());
            response.put("owner:", task.getOwner());
            response.put("name", task.getName());
            response.put("key", task.getTaskDefinitionKey());
            response.put("executionId", task.getExecutionId());
            response.put("id:", task.getId());
            response.put("suspended", task.isSuspended());
            response.put("DelegationState", task.getDelegationState());
            response.put("ProcessDefinitionId", task.getProcessDefinitionId());
            response.put("ProcessInstanceId", task.getProcessInstanceId());
            response.put("createTime", task.getCreateTime());
            response.put("ProcessVariables", task.getProcessVariables());
            response.put("TaskLocalVariables", task.getTaskLocalVariables());
            log.info("任务信息:" + response);
            responseList.add(response);
        }
        return responseList;
    }
}
