package com.bvgol.thread.completableFutureTest;/**
 * @Classname Test1
 * @Description TODO
 * @Date 2020/12/28 11:15
 * @Created by GUOCHEN
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @program: my-springboot-completely
 * @description: 模拟low 写法
 * @author: GUOCHEN
 * @create: 2020/12/28 11:15
 */
public class CompletableFutureSimpleDemo {
    //IntStream.range(1,9).boxed().findFirst().toString();

    /**
     * 功能描述:模拟业务代码
     *
     * @param
     * @return: java.lang.String
     * @author: 郭辰
     * @date: 2020/12/28 13:45
     */
    public static String step1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("step1");
        return "step1";
    }

    /**
     * 功能描述:模拟业务代码
     *
     * @param
     * @return: java.lang.String
     * @author: 郭辰
     * @date: 2020/12/28 13:45
     */
    public static String step2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("step2");
        return "step2";
    }

    /**
     * 功能描述:模拟业务代码
     *
     * @param
     * @return: java.lang.String
     * @author: 郭辰
     * @date: 2020/12/28 13:45
     */
    public static String step3() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("step3");
        return "step3";
    }

    /**
     * 功能描述:模拟业务代码
     *
     * @param
     * @return: java.lang.String
     * @author: 郭辰
     * @date: 2020/12/28 13:45
     */
    public static String step4() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("step4");
        return "step4";
    }

    /**
     * 功能描述: 模拟业务代码
     *
     * @param
     * @return: java.lang.String
     * @author: 郭辰
     * @date: 2020/12/28 13:46
     */
    public static String step5() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("step5");
        return "step5";
    }

    /**
     * 功能描述: 模拟串行
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2020/12/28 13:32
     */
    public static void line() throws InterruptedException {
        CompletableFutureSimpleDemo.step1();
        CompletableFutureSimpleDemo.step2();
        CompletableFutureSimpleDemo.step3();
        CompletableFutureSimpleDemo.step4();
        CompletableFutureSimpleDemo.step5();
    }

    /**
     * 功能描述: 全部都异步,保证不了调用顺序
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2020/12/28 13:32
     */
    public static void completable_supplyAsync() throws InterruptedException {
        CompletableFuture step1 = CompletableFuture.supplyAsync(() -> {
            try {
                return CompletableFutureSimpleDemo.step1();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture step2 = CompletableFuture.supplyAsync(() -> {
            try {
                return CompletableFutureSimpleDemo.step2();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture step3 = CompletableFuture.supplyAsync(() -> {
            try {
                return CompletableFutureSimpleDemo.step3();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture step4 = CompletableFuture.supplyAsync(() -> {
            try {
                return CompletableFutureSimpleDemo.step4();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture step5 = CompletableFuture.supplyAsync(() -> {
            try {
                return CompletableFutureSimpleDemo.step5();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture.allOf(step1, step2, step3, step4, step5).join();

    }

    /**
     * 功能描述: 实际用法 先串行 并行需要串行结果
     *
     * @param
     * @return: void
     * @author: 郭辰
     * @date: 2020/12/28 13:41
     */
    public static void actual() throws InterruptedException {
        String step1 = CompletableFutureSimpleDemo.step1();
        if (step1 == null || step1.equals("") || step1.equals(" ")) {
            return;
        }
        CompletableFuture step2 = CompletableFuture.supplyAsync(() -> {
            try {
                step1.length();
                return CompletableFutureSimpleDemo.step2();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture step3 = CompletableFuture.supplyAsync(() -> {
            try {
                step1.length();
//                int i =1/0;
                return CompletableFutureSimpleDemo.step3();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture step4 = CompletableFuture.supplyAsync(() -> {
            try {
                step1.length();
                return CompletableFutureSimpleDemo.step4();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture step5 = CompletableFuture.supplyAsync(() -> {
            try {
                step1.length();
                return CompletableFutureSimpleDemo.step5();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        CompletableFuture.allOf(step2, step3, step4, step5).join();
    }

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
//        Test1.line();//5003 搜有代码块时间合计
//        Test1.completable_supplyAsync();//1074 全部并行
        CompletableFutureSimpleDemo.actual();//2055
        //有异常时  异常步骤报异常 非异常代码段还是可以执行
        System.out.println("=============");
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

}
