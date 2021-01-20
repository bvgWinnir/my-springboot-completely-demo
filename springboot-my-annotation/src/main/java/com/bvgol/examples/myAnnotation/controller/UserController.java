package com.bvgol.examples.myAnnotation.controller;

import com.bvgol.examples.myAnnotation.ann.ApiOperateLog;
import com.bvgol.examples.myAnnotation.constants.LogConst;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperateLog(logName = "查询日志", logType = LogConst.LogType.LogType_SELECT, logModule = LogConst.LogModule.LOG_USER_INFO)
    @GetMapping("/{id}")
    public Object selectById(@PathVariable("id") int id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Instant.now();
    }
}
