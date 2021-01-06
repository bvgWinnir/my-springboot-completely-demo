package com.atguigu.juc;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @program: my-springboot-completely
 * @description: callable
 * @author: GUOCHEN
 * @create: 2021/01/05 16:11
 */
public class TestCallable {
    @SneakyThrows
    public static void main(String[] args) {
        Tx tx = new Tx();
        // 执行callable 方式,需要futureTask 实现类的支持,用于接收运算结果
        FutureTask<Integer> result = new FutureTask<Integer>(tx);
        new Thread(result).start();

        //2.接收线程运算后的结果
        System.out.println("---------------------it`s my turn---------------------------------");
        //自动闭锁了
        System.out.println("result.get() = " + result.get());
    }

}

class Tx implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum++;
        }
        return sum;
    }
}
