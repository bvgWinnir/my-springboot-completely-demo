package com.bvgol.lambda;/**
 * @Classname Test2
 * @Description TODO
 * @Date 2020/11/2 16:31
 * @Created by GUOCHEN
 */

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/02 16:31
 */
public class Test2 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        //8
        TreeSet<String> ts2 = new TreeSet<>(
                (o1, o2) -> Integer.compare(o1.length(), o2.length())
        );
    }
}
