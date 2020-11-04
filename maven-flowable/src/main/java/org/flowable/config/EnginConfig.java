package org.flowable.config;/**
 * @Classname EnginConfig
 * @Description TODO
 * @Date 2020/10/30 9:44
 * @Created by GUOCHEN
 */

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;

/**
 * @program: my-springboot-completely
 * @description: 引擎配置
 * @author: GUOCHEN
 * @create: 2020/10/30 09:44
 */
public class EnginConfig {
    public static ProcessEngine processEngine = null;

    static {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://47.94.43.15:3306/flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("root")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        processEngine = cfg.buildProcessEngine();
    }

    public static void main(String[] args) {
        System.out.println("EnginConfig.processEngine = " + EnginConfig.processEngine);
    }
}
