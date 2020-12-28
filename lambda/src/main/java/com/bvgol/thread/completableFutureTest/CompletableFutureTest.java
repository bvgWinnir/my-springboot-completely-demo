package com.bvgol.thread.completableFutureTest;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @program: my-springboot-completely
 * @description: CompletableFutureTest
 * @author: GUOCHEN
 * @create: 2020/12/28 10:11
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {

//        test1();
//        test2();
//        test3();
//        test4();
        test9();
    }

    //采用了callable+ future方式  ,get方法获取任务的返回值会被阻塞住
    public static void test1() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> result = executor.submit(() -> {
            //模拟执行耗时任务
            System.out.println("task doing...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return "result";
        });
        //这里只是将空闲的线程中断，将线程池的状态改为shutdown,不能继续往线程池中添加任务
        executor.shutdown();
        System.out.println("task运行结果" + result.get());
    }

    //采用了competableFuture，采用回调的方式获取任务的返回值
    public static void test2() throws Exception {
        //supplyAsync内部使用ForkJoinPool线程池执行任务
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            //模拟执行耗时任务
            System.out.println("task doing...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //返回结果
            return "100";
        }).whenComplete((v, r) -> {
            System.out.println("计算结果是: " + v);
        });
        //CompletableFuture里使用的线程池里的线程默认是daemon的。main线程结束后，整个程序也
        //结束了，这里将main线程join后任务里的代码才可以执行完
        Thread.currentThread().join();
    }

    //compeltableFuture可以支持级联操作
    public static void test3() throws Exception {
        IntStream.range(1, 10).boxed().forEach(i -> CompletableFuture.supplyAsync(CompletableFutureTest::get)
                .thenAccept(CompletableFutureTest::display)
                .whenComplete((v, r) ->
                        System.out.println(i + " have done")
                )
        );
        Thread.currentThread().join();
    }

    public static void display(int data) {
        int value = ThreadLocalRandom.current().nextInt(10);
        try {
            System.out.println(Thread.currentThread().getName() + "  display  data " + data + " will sleep " + value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  dispaly have done  with  data =  " + data);
    }

    public static int get() {
        int value = ThreadLocalRandom.current().nextInt(10);
        try {
            System.out.println(Thread.currentThread().getName() + "  get will sleep " + value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  get have done  " + value);
        return value;
    }

    //两个线程分别执行任务，任务都执行完后再执行最后的runnable
    public static void test4() throws InterruptedException {
        CompletableFuture.supplyAsync(Object::new)
                .thenAcceptAsync(obj -> {
                    try {
                        System.out.println("obj ====== start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("obj ====== " + obj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).runAfterBoth(CompletableFuture.supplyAsync(() -> "hello")
                .thenAcceptAsync((v) -> {
                    try {
                        System.out.println("string ====== start");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("string ====== " + v);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }), () -> System.out.println("finished"));
        Thread.currentThread().join();
    }

    //一个线程计算奇数和，一个线程计算偶数和，main线程将他们相加
    public static void test9() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> oddNumber = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("开始计算奇数和  ...");
                Thread.sleep(3_000);
                System.out.println("结束计算奇数和  ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1 + 3 + 5 + 7 + 9;
        });
        CompletableFuture<Integer> evenNumber = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("开始计算偶数和  ...");
                Thread.sleep(2_000);
                System.out.println("结束计算偶数和  ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2 + 4 + 6 + 8;
        });
        long startTime = System.currentTimeMillis();
        CompletableFuture<Integer> resultFuturn = oddNumber.thenCombine(evenNumber, (odd, even) -> {
            return odd + even;
        });
        System.out.println("===============");
        System.out.println("运行结果是：" + resultFuturn.get() + " 总共耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
