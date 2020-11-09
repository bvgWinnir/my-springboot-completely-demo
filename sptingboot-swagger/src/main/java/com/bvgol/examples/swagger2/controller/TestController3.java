package com.bvgol.examples.swagger2.controller;

import com.bvgol.examples.swagger2.entity.TestEntity2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "研究不同法之间的参数区别显示")
@RequestMapping("/swagger/demo3")
public class TestController3 {

    @PostMapping("xxx/add")
    @ApiOperation(value = "这里是添加方法,期望在api中只看到name和age", httpMethod = "POST",
            notes = "这里是notes信息", response = TestEntity2.class)
    public Object add(@RequestBody TestEntity2 testEntity) {
        Map<Instant, TestEntity2> map = new HashMap<>(16);
        map.put(Instant.now(), testEntity);
        return map;
    }

    @PostMapping("xxx/update")
    @ApiOperation(value = "这里是修改方法,期望在api中只看到id和status", httpMethod = "POST",
            notes = "这里是notes信息", response = TestEntity2.class)
    public Object update(@RequestBody TestEntity2 testEntity) {
        Map<Instant, TestEntity2> map = new HashMap<>(16);
        map.put(Instant.now(), testEntity);
        return map;
    }

    //localhost:10006/swagger-ui.html
}
