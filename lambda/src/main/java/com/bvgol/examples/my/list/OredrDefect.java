package com.bvgol.examples.my.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class OredrDefect {
    public static void main(String[] args) {
        List<Integer> ints= Arrays.asList(6,7,6,7,9,4,1,2,3,4,9,12);
//        Collections.sort(ints);
//        ints.forEach(System.out::println);

        List<Integer>  ss= new ArrayList<>(new TreeSet<>(ints));

        Integer end = ss.get(ss.size()-1);
        System.out.println(end);
        System.out.println("-----------------------------------------------------------------");
        ss.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");
        StringBuffer sb = new StringBuffer();;
        for (int i = 1; i <= end; i++) {

            if (! ss.contains(i)){
                System.out.println(i);
                sb.append(i);
            }
        }
    }
}
