package com.bvgol.examples.springbootargs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class SpringbootArgsApplicationTests {

    @Test
    void contextLoads() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(s);
    }

}
