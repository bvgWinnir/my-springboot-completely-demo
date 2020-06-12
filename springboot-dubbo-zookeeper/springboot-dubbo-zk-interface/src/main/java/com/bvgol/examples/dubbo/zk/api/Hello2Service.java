package com.bvgol.examples.dubbo.zk.api;


/**
 * @Classname HelloService
 * @Description TODO
 * @Date 2020/5/9 10:36
 * @Created by guochen
 */

public interface Hello2Service {
    String testDubbo();

    /**
     * 测试生产者间相互调用
     * @return
     */
    String testDubbo2();
}
