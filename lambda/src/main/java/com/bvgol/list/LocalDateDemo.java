package com.bvgol.list;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo {
    public static void main(String[] args) {

        // 解析日期
//        LocalDate date = str2LocalDate();

        // 格式化日期
//        localdate2str(date);

        //示例1： 获取当天日期
        //
        //　　　　Java 8中的 LocalDate 用于表示当天日期。和java.util.Date不同，它只有日期，不包含时间。
//        localdate();

//        示例2： 构造指定日期
//
//　　　　调用工厂方法LocalDate.of()创建任意日期， 该方法需要传入年、月、日做参数，返回对应的LocalDate实例。这个方法的好处是没再犯老API的设计错误，比如年度起始于1900，月份是从0开始等等
//        LocalDate date = LocalDate.of(2000, 1, 1);
//        System.out.println("千禧年=" + date);

        //示例3： 获取年月日信息
        LocalDate date = LocalDate.now();
        System.out.printf("年=%d， 月=%d， 日=%d", date.getYear(), date.getMonthValue(), date.getDayOfMonth());

    }

    private static void localdate() {
        LocalDate date = LocalDate.now();
        System.out.println("当前日期=" + date);
    }

    private static void localdate2str(LocalDate date) {
        String dateText;
        dateText = date.format(DateTimeFormatter.ISO_DATE);
        System.out.println("dateText=" + dateText);
    }

    private static LocalDate str2LocalDate() {
        String dateText = "20180924";
        LocalDate date = LocalDate.parse(dateText, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("格式化之后的日期=" + date);
        return date;
    }
}
