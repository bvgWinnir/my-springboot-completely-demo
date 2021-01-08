package com.bvgol.examples.my;

/**
 * @Classname IntergerTest
 * @Description TODO
 * @Date 2020/9/10 17:41
 * @Created by GUOCHEN
 */
public class IntergerTest {
    public static void main(String[] args) {
        Integer i = 1;
        int i1 = i.compareTo(100);
        System.out.println("i1 = " + i1);

        Integer l= 100;
        int i2 = l.compareTo(100);
        System.out.println("i2 = " + i2);

        Integer ll = 101;
        int i3 = ll.compareTo(100);
        System.out.println("i3 = " + i3);

    }
}
