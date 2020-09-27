package com.bvgol.time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TimeDemo {
    /**
     * 把long 转换成 日期 再转换成String类型
     */
    public static String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    public static void main(String[] args) {
//        String s = TimeDemo.transferLongToDate("yyyy-mm-dd hh:mm:ss", 1594013518000L);
//        System.out.println("s = " + s);
//        dateGetYear();

        String s = LocalDate.now().toString();
        System.out.println("s = " + s);
        s =s.replaceAll("-","");
        String substring = s.substring(0, 6);
        System.out.println("substring = " + substring);
    }



    public static void dateGetYear(){
        System.out.println(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
    }

}
