package com.bvgol.examples.springbootmybatisplus.complateAbleFutureTest;

import com.bvgol.examples.springbootmybatisplus.service.logic.SimulationComplateAbleFuture;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/12/30 15:16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplateAbleFutureTest {

    @Autowired
    private SimulationComplateAbleFuture simulationComplateAbleFuture;

    @Test
    public void one() {
        simulationComplateAbleFuture.one();
    }

    @Test
    public void someExample() {
        simulationComplateAbleFuture.someExample();
    }

    @Test
    public void tr() {
        simulationComplateAbleFuture.tr();
    }

    @Test
    public void trNESTED() {
        simulationComplateAbleFuture.trNESTED();
    }

    @Test
    public void trComNESTED() {
        //所有子事务都需要 加嵌套事务注解 不加的不会回滚事务 而且主事务也不会回滚
        simulationComplateAbleFuture.trComNESTED();
    }

}
