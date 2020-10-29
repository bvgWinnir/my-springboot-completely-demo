package com.bvgol.map;/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/10/23 14:37
 * @Created by GUOCHEN
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/10/23 14:37
 */
public class Test {
    public static void main(String[] args) {
        Map<String,A> Amap =new LinkedHashMap<>();
        Map<String, String> map = new LinkedHashMap<>();

        Amap.put("1",A.builder().i(1).build());
        Amap.put("2",A.builder().i(1).build());
        Amap.put("3",A.builder().i(1).build());


        map.put("1","aa");
        map.put("4","aa");
        map.put("5","aa");


//        map.putAll(Amap); //编译报错  类型不一致


    }




}
