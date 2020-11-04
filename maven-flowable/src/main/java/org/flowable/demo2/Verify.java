package org.flowable.demo2;/**
 * @Classname Verify
 * @Description TODO
 * @Date 2020/10/30 10:00
 * @Created by GUOCHEN
 */

import org.flowable.config.EnginConfig;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.repository.Deployment;
import org.flowable.task.api.Task;

import java.util.List;

/**
 * @program: my-springboot-completely
 * @description: 简单用例操作
 * @author: GUOCHEN
 * @create: 2020/10/30 10:00
 */
public class Verify {

    public static void main(String[] args) {
        //  创建 Flowable 流程引擎
        ProcessEngine processEngine = EnginConfig.processEngine;
        //  获取 Flowable 服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

//  部署流程定义
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("FinancialReportProcess.bpmn20.xml")
                .deploy();

        //  启动流程实例 并流式调用id
        String procId = runtimeService.startProcessInstanceByKey("financialReport").getId();

        //获取这个任务

        List<Task> tasksByCandidateUser = taskService.createTaskQuery().taskCandidateUser("kermit").list();

        //也可以使用任务查询API，用组名查得相同结果
        List<Task> tasksByCandidateGroup = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();

        //代码实现申领任务
//        taskService.claim(task.getId(), "fozzie");
        //申领任务者的个人任务列表中
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("fozzie").list();

        //完成任务
        //会计师（accountancy组的成员）现在需要开始撰写财务报告了。完成报告后，他就可以 完成任 务（ （complete ），代表任务的所有工作都已完成。
//        taskService.complete(task.getId());

        for (Task task : tasks) {
            System.out.println("Following task is available for accountancy group: " + task.getName());
//  申领任务
            taskService.claim(task.getId(), "fozzie");
        }
//  验证 Fozzie 获取了任务
        tasks = taskService.createTaskQuery().taskAssignee("fozzie").list();
        for (Task task : tasks) {
            System.out.println("Task for fozzie: " + task.getName());
//  完成任务
            taskService.complete(task.getId());
        }
        System.out.println("Number of tasks for fozzie: "
                + taskService.createTaskQuery().taskAssignee("fozzie").count());
//  获取并申领第二个任务
        tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
        for (Task task : tasks) {
            System.out.println("Following task is available for management group: " + task.getName());
            taskService.claim(task.getId(), "kermit");
        }
//  完成第二个任务并结束流程
        for (Task task : tasks) {
            taskService.complete(task.getId());
        }
//  验证流程已经结束
        HistoricProcessInstance historicProcessInstance =
                historyService.createHistoricProcessInstanceQuery().processInstanceId(procId).singleResult();
        System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());

    }

}
