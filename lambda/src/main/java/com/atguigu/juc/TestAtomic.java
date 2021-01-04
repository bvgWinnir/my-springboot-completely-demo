package com.atguigu.juc;/**
 * @Classname TestAtomic
 * @Description TODO
 * @Date 2021/1/4 16:53
 * @Created by GUOCHEN
 */

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: my-springboot-completely
 * @description: 原子性
 * 原子变量  java.util.concurrent.atomic 包下提供了常用的原子变量
 * CAS compare and swap 算法保证数据的原子性
 * CAS 算法是硬件对于并发操作共享数据的支持
 * CAS 包含了3个操作数:
 * 内存值:V
 * 预估值:A
 * 更新值:B
 * 当且仅当 V==A 时,V=B 否则将不做任何操作
 * new Thread( () -> System.out.println("In Java8, Lambda expression") ).start();
 * @author: GUOCHEN
 * @create: 2021/01/04 16:53
 */
public class TestAtomic {
    public static void main(String[] args) {
        //i++ 的原子性问题:i++ 的操作实际上分为三个步骤"读-改-写"
        int i = 10;
        i = i++;
        System.out.println("i = " + i);
        /**
         * int temp = i;
         * i = i+1;
         * i = temp;
         */

//        noAtomic();
        atomic();

    }

    private static void atomic() {
        AtomicDemoA a = new AtomicDemoA();
        for (int j = 0; j < 10; j++) {
            new Thread(a).start();
        }
    }

    private static void noAtomic() {
        AtomicDemo a = new AtomicDemo();
        for (int j = 0; j < 10; j++) {
            new Thread(a).start();
        }
    }
}

class AtomicDemo implements Runnable {

    private int serialNumber = 0;

    @SneakyThrows
    @Override
    public void run() {
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber++;
    }
}

class AtomicDemoA implements Runnable {

    private AtomicInteger serialNumber = new AtomicInteger();

    @SneakyThrows
    @Override
    public void run() {
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}
