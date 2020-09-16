package com.bvgol.examples.springbootargs.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class TestDemoFrom {
    private String name;
    private Map<String, String> citys;
    private Date gmtStart;
    private Boolean flag;
    private Integer age;
    private List<String> types;
    private List<DemoVo> demoVos;

}