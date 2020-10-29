package com.bvgol.examples.springbootdocker.controller;
import java.util.Date;

import com.bvgol.examples.springbootdocker.mapper.CronMapper;
import com.bvgol.examples.springbootdocker.model.Cron;
import com.bvgol.examples.springbootdocker.model.User;
import com.bvgol.examples.springbootdocker.service.CronService;
import com.bvgol.examples.springbootdocker.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {



    @Autowired      //注入mapper
    @SuppressWarnings("all")
    private CronService cronService;

    @Autowired
    private UserService userService;

    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> log.info("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期

                    long start = System.currentTimeMillis();

                    Cron cron = cronService.getById(1L);
                    //2.2 合法性校验.
                    if (!StringUtils.isEmpty(cron.getCron())) {

                        List<User> list = new LinkedList<>();

                        for (int i = 0; i <10000 ; i++) {
                            User user = new User();
                            user.setUsername(UUID.randomUUID().toString().substring(0,4));
                            user.setPassword(UUID.randomUUID().toString().substring(0,4));
                            user.setSalt(UUID.randomUUID().toString().substring(0,4));
                            user.setEmail(UUID.randomUUID().toString().substring(0,4));
                            user.setMobile(UUID.randomUUID().toString().substring(0,4));
                            user.setStatus((byte)0);
                            user.setDeptId(0L);
                            user.setCreateTime(new Date());
                            list.add(user);
                        }

                        long end = System.currentTimeMillis();
                        log.info("构造10000对象耗时"+(end-start)+"ms");
//                        userService.save(user);
                        long startsaveBatch = System.currentTimeMillis();
                        userService.saveBatch(list);
                        long endsaveBatch = System.currentTimeMillis();
                        log.info("批量添加耗时"+(endsaveBatch-startsaveBatch)+"ms");

                        int count = userService.count();
                        log.info("当前数据行:"+count);
                        log.info("总耗时"+(System.currentTimeMillis()-start)+"ms");

                        /***
                         * 这里会出现   定时任务的时间步长小于执行时间
                         * 1.算出第一次的时间 然后反向更新 定时任务时间 同时需要发送邮件和短信等通知相关人员
                         *   不行 因为有可能已经积累多次定时任务(如何验证)
                         *   在预期的时间内没有完成 就先去更新定时任务 然后发送通知
                         * */
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron.getCron()).nextExecutionTime(triggerContext);
                }
        );
    }

}