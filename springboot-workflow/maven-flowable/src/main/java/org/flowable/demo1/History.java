package org.flowable.demo1;/**
 * @Classname History
 * @Description TODO
 * @Date 2020/10/29 15:27
 * @Created by GUOCHEN
 */

import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;

import java.util.List;

/**
 * @program: my-springboot-completely
 * @description: 显示流程实例已经执行的时间
 * @author: GUOCHEN
 * @create: 2020/10/29 15:27
 */
public class History {
    public static void main(String[] args) {

        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://47.94.43.15:3306/flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("root")
                .setJdbcDriver("com.mysql.jdbc.Driver")
//            .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
//            .setJdbcUsername("sa")
//            .setJdbcPassword("")
//            .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        /**
         *
         * databaseSchemaUpdate: 用于设置流程引擎启动关闭时使用的数据库表结构控制策略
         *false (默认): 当引擎启动时，检查数据库表结构的版本是否匹配库文件版本。版本不匹配时抛出异常。
         *
         * true: 构建引擎时，检查并在需要时更新表结构。表结构不存在则会创建。
         *
         * create-drop: 引擎创建时创建表结构，并在引擎关闭时删除表结构。
         */

        ProcessEngine processEngine = cfg.buildProcessEngine();

        //processInstance.getId() from act_hi_procinst.proc_inst_id

        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId("10004")
                        .finished()
                        .orderByHistoricActivityInstanceEndTime().asc()
                        .list();

        for (HistoricActivityInstance activity : activities) {
            System.out.println(activity.getActivityId() + " took "
                    + activity.getDurationInMillis() + " milliseconds");
        }
    }
}
