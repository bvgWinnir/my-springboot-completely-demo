package com.bvgol.examples.springbootargs.dto;

import com.bvgol.examples.springbootargs.pojo.Demo;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Data
@ToString
public class TestDemoDTO{
    private String name;
    private Map<String,String> citys;
    private Date gmtStart;
    private Boolean flag;
    private Integer age;
    private List<String> types;
    private List<Demo> demoVos;

}