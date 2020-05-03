package com.bvgol.examples.springbootmybatisplus.model;

import lombok.Data;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/4/26 16:09
 * @Created by guochen
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}