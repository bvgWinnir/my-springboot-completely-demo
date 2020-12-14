package org.flowable.demo1;/**
 * @Classname EventListen
 * @Description TODO
 * @Date 2020/10/29 16:28
 * @Created by GUOCHEN
 */

import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEventType;

/**
 * @program: my-springboot-completely
 * @description: 事件监听器  它将接收的所有事件打印至标准输出，并对作业执行相关的事件特别处理
 * @author: GUOCHEN
 * @create: 2020/10/29 16:28
 */
public class MyEventListener implements FlowableEventListener {

    @Override
    public void onEvent(FlowableEvent event) {
        FlowableEventType type = event.getType();
        if (FlowableEngineEventType.JOB_EXECUTION_SUCCESS.equals(type)) {
            System.out.println("A job well done!");
        } else if (FlowableEngineEventType.JOB_EXECUTION_FAILURE.equals(type)) {
            System.out.println("A job has failed...");
        } else {
            System.out.println("Event received: " + event.getType());
        }
    }

    @Override
    public boolean isFailOnException() {
        // onEvent方法中的逻辑并不重要，可以忽略日志失败异常……

        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false;
    }

    @Override
    public String getOnTransaction() {
        return null;
    }
}

//这段配置放哪儿?
//<bean id="processEngineConfiguration"
//class="org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration">
//        ...
//<property name="eventListeners">
//<list>
//<bean class="org.flowable.engine.example.MyEventListener" />
//</list>
//</property>
//</bean>
