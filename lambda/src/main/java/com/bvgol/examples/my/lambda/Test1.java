package com.bvgol.examples.my.lambda;/**
 * @Classname Test1
 * @Description TODO
 * @Date 2020/11/2 16:28
 * @Created by GUOCHEN
 */

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/02 16:28
 */
public class Test1 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        Runnable r2 = () -> System.out.println("hi 8");

//        Runnable r3 = System.out::print; //编译报错为什么
        Consumer<String> fun = (argss) -> System.out.println(args);
        Consumer<String> fun2 = System.out::println;

        BinaryOperator<Long> bo = (x, y) -> {
            System.out.println("模拟这里有一条语句,否则可以简化为 BinaryOperator<Long> bo = (x,y)->x+y    ");
            return x + y;
        };

        BinaryOperator<Long> bo1 = (x, y) -> x + y;
    }
}
