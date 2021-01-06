package com.atguigu.juc;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @program: my-springboot-completely
 * @description: 闭锁 在某些运算时,只有其他所有线程运算全部完成,当前运算才继续执行
 * @author: GUOCHEN
 * @create: 2021/01/05 15:49
 */
public class TestCountDownLatch {

    @SneakyThrows
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Integer count = 5;
        final CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(new LatchDemo(latch)).start();
        }
        latch.await();

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50000; i++) {
                if (i % 2 == 0) {
                    System.out.println("i = " + i);
                }
            }
        } finally {
            latch.countDown();
        }
    }
}
