package com.bvgol.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    public static void main(String[] args) {
//        StringIndexof();
//        getChineseChar();
        String s = "箱号:[箱号]# 图号:[图号]";
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            String suffix = str.substring(0, split[i].indexOf("["));
            String prefix = split[i].substring( split[i].indexOf("]"), split[i].length());
            System.out.println("suffix = " + suffix+"  "+"prefix = " + prefix);
        }

    }

    private static void getChineseChar() {
        String s = "[箱号]# [图号]";
        String[] split = s.split("]");
        String regex="([\u4e00-\u9fa5]+)";

        for (int i = 0; i < split.length; i++) {
            Matcher matcher = Pattern.compile(regex).matcher(split[i]);
            if(matcher.find()){
                split[i] =matcher.group(0);
                System.out.println(split[i]);
            }
        }
    }

    private static void StringIndexof() {
        String s = "[箱号]#";
        int i = s.indexOf("]");
        String substring = s.substring(i + 1, s.length());
        System.out.println(substring);
    }
}
