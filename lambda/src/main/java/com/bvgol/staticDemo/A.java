package com.bvgol.staticDemo;/**
 * @Classname A
 * @Description TODO 静态块优于构造函数执行
 * @Date 2020/10/30 9:47
 * @Created by GUOCHEN
 */

/**
 * @program: my-springboot-completely
 * @description: 静态快测试
 * @author: GUOCHEN
 * @create: 2020/10/30 09:47
 */
public class A {

    private static String s = null;

    static {
        s = "static";
        System.out.println("i'm static");
    }

//    public A() {
//        System.out.println(s);
//        System.out.println("i'm constructor");
//    }

    public static void main(String[] args) {
//        new A();
        System.out.println("A.s = " + A.s);
    }
}
