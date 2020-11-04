package experiment;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.Deployment;
import org.flowable.engine.test.FlowableRule;
import org.flowable.task.api.Task;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

public class MyBusinessProcessTest {

    /**
     * 需要配置文件  flowable.cfg.xml
     */

    @Rule
    public org.flowable.engine.test.FlowableRule FlowableRule = new FlowableRule();

    @Test
    @Deployment
    public void ruleUsageExample() {
        RuntimeService runtimeService = FlowableRule.getRuntimeService();
        runtimeService.startProcessInstanceByKey("holidayRequest");

        TaskService taskService = FlowableRule.getTaskService();
//    Task task = taskService.createTaskQuery().singleResult();
        List<Task> list = taskService.createTaskQuery().list();

//    assertEquals("My Task", task.getName());
        list.forEach(System.out::println);
//    taskService.complete(task.getId());
//    assertEquals(0, runtimeService.createProcessInstanceQuery().count());
    }
}
