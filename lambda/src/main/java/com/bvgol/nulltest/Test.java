package com.bvgol.nulltest;
/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/10/13 14:47
 * @Created by GUOCHEN
 */

import lombok.Data;

/**
 * @program: my-springboot-completely
 * @description: null 在前还是 .在前 有些工具类中 是obj 在前
 * @author: GUOCHEN
 * @create: 2020/10/13 14:47
 */
@Data
public class Test {

    private String name ;
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(null==t.getName());
        System.out.println(t.getName()==null);
    }
}
