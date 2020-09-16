package com.bvgol.examples.springbootargs.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
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
    private String demoName;
    @NotNull
    private String va_name;

    private Boolean va_boolean;

    private Integer va_int;

    @NotNull
    @Pattern(regexp="^[0-9]{11}$")
    private String phone;

    @Valid //嵌套校验
    public   InnerUserDTo innerUserDTo= new InnerUserDTo();

//    @Valid //嵌套校验   写法2
//    @NotNull
//    public   InnerUserDTo innerUserDTo;


    @Data
    private static  class InnerUserDTo{
        @NotEmpty
        private String children;
    }
}
