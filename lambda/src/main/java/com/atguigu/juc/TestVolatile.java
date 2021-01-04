package com.atguigu.juc;/**
 * @Classname TestVolatile
 * @Description TODO
 * @Date 2021/1/4 16:13
 * @Created by GUOCHEN
 */

import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @program: my-springboot-completely
 * @description: volatile
 * 1.轻量级的同步策略
 * 注意: volatile 不具备 互斥性
 * volatile 不能保证变量的 原子性
 * @author: GUOCHEN
 * @create: 2021/01/04 16:13
 */
public class TestVolatile {
    public static void main(String[] args) {
//        nosee();
//        seeBySynchronized();
        seeByVolatile();
    }

    /**
     * 功能描述:volatile 简单:实时刷新主存.内存栅栏
     * 进阶:禁止了指令重排(需要开class 的字节码)
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2021/1/4 16:34
     */
    private static void seeByVolatile() {
        ThreadDemo t = new ThreadDemo();
        new Thread(t).start();

        System.out.println("while 判断前------t.isFlag() = " + t.isFlag());
        System.out.println("while 判断前------t.isFlag() = " + t.isFlag_v());

        while (true) {
            if (t.isFlag_v()) {
                System.out.println("while 判断中------t.isFlag() = " + t.isFlag());
                System.out.println("while 判断中------t.isFlag_v() = " + t.isFlag_v());
                break;
            }
        }
        System.out.println("while 判断后------t.isFlag() = " + t.isFlag());
        System.out.println("while 判断后------t.isFlag() = " + t.isFlag_v());
    }

    /**
     * 功能描述:synchronized 同步了现成的内存变量
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2021/1/4 16:34
     */
    private static void seeBySynchronized() {
        ThreadDemo t = new ThreadDemo();
        new Thread(t).start();

        System.out.println("while 判断前------t.isFlag() = " + t.isFlag());

        while (true) {
            synchronized (t) {
                //同步锁 锁现成
                if (t.isFlag()) {
                    System.out.println("while 判断中------t.isFlag() = " + t.isFlag());
                    break;
                }
            }
        }
        System.out.println("while 判断后------t.isFlag() = " + t.isFlag());
    }

    /**
     * 功能描述: 内存不可见
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2021/1/4 16:34
     */
    private static void nosee() {
        ThreadDemo t = new ThreadDemo();
        new Thread(t).start();

        System.out.println("while 判断前------t.isFlag() = " + t.isFlag());
        /**此时flag 内存不可见  (内存可见性)*/
        while (true) {
            if (t.isFlag()) {
                System.out.println("while 判断中------t.isFlag() = " + t.isFlag());
                break;
            }
        }
        System.out.println("while 判断后------t.isFlag() = " + t.isFlag());
    }

}

@Data
class ThreadDemo implements Runnable {

    private boolean flag = false;
    private volatile boolean flag_v = false;

    @SneakyThrows(InterruptedException.class)
    @Override
    public void run() {
        TimeUnit.SECONDS.sleep(2);
        flag = true;
        flag_v = true;
        System.out.println("flag = " + flag);
        System.out.println("flag_v = " + flag_v);
    }
}
