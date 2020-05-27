package com.bvgol.examples.swagger2.controller;

import com.bvgol.examples.swagger2.entity.TestEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "spring boot swagger demo22222")
@RequestMapping("/swagger/dome2")
public class SwaggerDemoController2 {
 
    @ResponseBody
    @ApiOperation(value = "swagger2示例接口描述",httpMethod = "POST",
            notes = "这里是notes信息", response = TestEntity.class)
    @RequestMapping("/list2")
    public TestEntity listTest(TestEntity testEntity) {
        return testEntity;
    }
    
     @RequestMapping("/list22")
    public String listTest2(@ApiParam(name = "name", value = "value",
            allowableValues = "test2",example = "小王", required = true) String name) {
        return name + ", hello";
    }

    //localhost:10006/swagger-ui.html
}