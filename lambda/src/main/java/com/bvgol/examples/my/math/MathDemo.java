package com.bvgol.examples.my.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class MathDemo {
    public static void main(String[] args) {
        MathDemo.SetMathRandom();
    }
    public static void SetMath() {
        double ceil = Math.ceil(16.34);//Cell返回大于指定数据的最小整数   17.0
        sop(ceil);
        double floor = Math.floor(12.52);//floor返回小于指定数据的最小整数  12.0
        sop(floor);
        long round = Math.round(13.51); //四舍五入
        sop(round);
        double pow = Math.pow(2, 3); //pow(double a, double b); 表示2的3次幂  8.0
        sop(pow);
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }

    public static void SetMathRandom() {
        for (int i = 0; i < 10; i++) {
            int s = (int) (Math.random() * 10 + 1); //因为Math.random()方法获取到的是0.0到1.0之前的小数但是又不包括1是所有要加1
            System.out.print(s + ",");
        }
    }

    //使用Util包下的Random类实现随机数
    public static void SetUrtlRandom() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt(10) + 1; //因为nextInt（10）；方法表示从0到10但是不包括10
            System.out.print(nextInt + ",");
        }
    }

    /*
     * 练习：给定一个小数，保留小数的后两位
     * 	下面给出四种方法
     */
    public static void Demo(Double price) {

        BigDecimal bg = new BigDecimal(price);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);

        //DecimalFormat转换最简便
        DecimalFormat decimalFormat = new DecimalFormat("#.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p = decimalFormat.format(price);//format 返回的是字符串
        System.out.println(p);

        //String.format打印最简便
        String format = String.format("%.2f", price);
        System.out.println(format);

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        String format2 = nf.format(price);
        System.out.println(format2);
    }

}
