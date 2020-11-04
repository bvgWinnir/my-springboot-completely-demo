package com.bvgol.lambda;/**
 * @Classname TestFunctionalInterface
 * @Description TODO
 * @Date 2020/11/2 16:56
 * @Created by GUOCHEN
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/02 16:56
 */
public class TestFunctionalInterface {

    public static void main(String[] args) {
        TestFunctionalInterface t = new TestFunctionalInterface();
        //1
        t.toUpperString(s -> s.toUpperCase(), "aa");
        //2
        String awww = t.toUpperString(String::toUpperCase, "awww");

        t.toUpperString(String::toLowerCase, "jj");
        System.out.println(awww);

    }

    @Test
    public void name() {
        Function qqq = opStr("", (s) -> s);
        Function function = qqq.andThen(s -> s + "-------------");
        Function compose = function.compose(qqq);
        //迷路了
    }

    Function opStr(String s, Function<String, String> function) {
        return function.andThen(s1 -> s1 + s);
    }

    /**
     * function
     * 处理一下字符串
     */
    @Test
    public void name1() {
        int aaaaa = opString("aaaaa", s -> {
            //此处有戏
            if (s.contains("a")) {
                return 1;
            } else {
                return 2;
            }
        });
        System.out.println("aaaaa = " + aaaaa);
    }

    int opString(String s, Function<String, Integer> function) {
        return function.apply(s);
    }

    /**
     * Supplier 生成10个整数并返回一个list
     */
    @Test
    public void test1() {
        List<Integer> nmuList = getNmuList(10, () -> (int) (Math.random() * 100));
        /**
         * (int) (Math.random() * 100) 与 (int) Math.random() * 100 的区别
         */
        nmuList.forEach(System.out::println);
    }

    /**
     * 生成10个整数并返回一个list
     */
    List<Integer> getNmuList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    @Test
    public void testConsumer() {

        Consumer<String> consumer = x -> System.out.println("我是实现/按需实现/想怎么实现就怎么实现" + x);
        //开始调用
        consumer.accept("-我是参数-");
        consumer.andThen(x -> System.out.println("又懵逼了"));
    }

    @Test
    public void testComparator() {
        Comparator<Integer> c = (x, y) -> {
            System.out.println("模拟这里有句有用的代码");
            return x + y;//Integer.compare(x,y);
        };
        int compare = c.compare(1, 2);

        System.out.println("compare = " + compare);
        //修改了默认实现?????还是自己实现了接口?
    }

    public String toUpperString(MyFunc<String> myFunc, String string) {
        return myFunc.getValue(string);
    }

    public double tt(MyNumber myNumber, Double d) {
        return myNumber.getValue();
    }
}

@FunctionalInterface
interface MyNumber {
    Double getValue();
}

@FunctionalInterface
interface MyFunc<T> {
    T getValue(T t);
}
