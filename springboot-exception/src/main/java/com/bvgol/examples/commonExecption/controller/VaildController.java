package com.bvgol.examples.commonExecption.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validated")
public class VaildController {

    @PostMapping("validated")
    public Object xxx(@Validated @RequestBody Demo demo ){

        return demo;
    }
}
