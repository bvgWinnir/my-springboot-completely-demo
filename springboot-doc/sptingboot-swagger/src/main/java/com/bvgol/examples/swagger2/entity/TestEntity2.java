package com.bvgol.examples.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("swaggerDome2实体")
public class TestEntity2 implements Serializable {
    // 名称
    @ApiModelProperty(name = "name",
            value = "名称：用户名称",
            required = true,
            access = "access",
            notes = "这个是提示信息",
            dataType = "dataType")
    private String name;
    // id
    @ApiModelProperty(value = "用户id，默认为010001",
            allowableValues = "010001,020001,030001,040001,050001,060001,070001,080001,090001,100001,110001,120001,990001")

    private String id;//添加不传 /修改必传

    private int age;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
