package com.atguigu.java8.lamdba;

@FunctionalInterface
public interface MyPredicate<T> {

    public boolean test(T t);

}
