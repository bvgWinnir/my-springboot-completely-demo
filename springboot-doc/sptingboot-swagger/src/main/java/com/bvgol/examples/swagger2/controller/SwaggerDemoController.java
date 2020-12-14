package com.bvgol.examples.swagger2.controller;

import com.bvgol.examples.swagger2.entity.TestEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "why work to controller ")
@RequestMapping("/swagger/dome")
public class SwaggerDemoController {

    @ApiOperation(value = "swagger2示例接口描述1", httpMethod = "POST",
            notes = "这里是notes信息", response = TestEntity.class)
    @PostMapping("/list")
    public TestEntity listTest(@RequestBody TestEntity testEntity) {
        return testEntity;
    }

    @PostMapping("/list2")
    public String listTest2(@ApiParam(name = "name", value = "value",
            allowableValues = "test2", example = "小王", required = true) String name) {
        return name + ", hello";
    }

    //localhost:10006/swagger-ui.html

    //this api only have /list
}
