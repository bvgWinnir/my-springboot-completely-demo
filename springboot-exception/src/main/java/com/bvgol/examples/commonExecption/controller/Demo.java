package com.bvgol.examples.commonExecption.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2020/5/30 10:23
 * @Created by guochen
 */
@Slf4j
@Data
public class Demo {
    @NotEmpty(message = "demoName中文 notempty")
    private String demoName;
    @NotNull
    @NotBlank//不是空白的    发送 "va_name": "",  被拦下
    private String va_name;


    private Boolean va_boolean;


    private Integer va_int;

    @NotNull
    @Pattern(regexp="^[0-9]{11}$")
    private String phone;



//    @Valid //嵌套校验
//    public   InnerUserDTo innerUserDTo= new InnerUserDTo();
//
////    @Valid //嵌套校验   写法2
////    @NotNull
////    public   InnerUserDTo innerUserDTo;
//
//
//    @Data
//    private static  class InnerUserDTo{
//        @NotEmpty
//        private String children;
//    }
}
