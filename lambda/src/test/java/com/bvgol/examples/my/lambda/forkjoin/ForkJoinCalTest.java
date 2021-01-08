package com.bvgol.examples.my.lambda.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Classname ForkJoinCalTest
 * @Description TODO
 * @Date 2020/11/3 17:02
 * @Created by GUOCHEN
 */
public class ForkJoinCalTest {

    @Test
    public void compute() {
        Instant now = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCal(0, 100000000L);
        Long invoke = pool.invoke(task);
        System.out.println("invoke = " + invoke);
        Instant end = Instant.now();
        long l = Duration.between(now, end).toMillis();
        System.out.println("l = " + l);
    }

    @Test
    public void java8parallel() {
        Instant now = Instant.now();
        long reduce = LongStream.rangeClosed(0, 100L).parallel().reduce(0, Long::sum);
        Instant end = Instant.now();
        long l = Duration.between(now, end).toMillis();
        System.out.println("l = " + l);
    }
}
