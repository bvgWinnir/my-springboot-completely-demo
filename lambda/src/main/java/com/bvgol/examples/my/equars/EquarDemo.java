package com.bvgol.examples.my.equars;

public class EquarDemo {
    public static void main(String[] args) {
        Integer a = new Integer(4);
        Integer b = new Integer(4);
        System.out.println("a.equals(b) = " + a.equals(b));
        System.out.println("a==(b) = " + (a==b));

        int a_1000 = 1000;
        int b_1000 = 1000;
        System.out.println("int = " + (a_1000==b_1000));


        Integer Integer_a_1000 = 1000;
        Integer Integer_b_1000 = 1000;
        System.out.println("Integer.equals = " + (Integer_a_1000.equals(Integer_b_1000)));
        System.out.println("Integer.== = " + (Integer_a_1000==Integer_b_1000));



        Integer instant_Integer_a_1000 = new Integer(1000);
        Integer instant_Integer_b_1000 = new Integer(1000);
        System.out.println("Integer_instants.equals = " + (instant_Integer_a_1000.equals(instant_Integer_b_1000)));
        System.out.println("Integer_instants.== = " + (instant_Integer_a_1000==instant_Integer_b_1000));
    }
}
