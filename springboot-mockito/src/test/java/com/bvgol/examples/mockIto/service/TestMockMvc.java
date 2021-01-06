package com.bvgol.examples.mockIto.service;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
//单元测试Controller：java.lang.IllegalArgumentException: WebApplicationContext is required
@RunWith(SpringRunner.class)
public class TestMockMvc {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testMvc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/findById?id=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;

    }

    @Test
    public void testMvc1() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/user/findById?id=1")
                //设置content-type:解决中文乱码问题
                .accept(MediaType.APPLICATION_JSON_UTF8))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("师傅")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("师傅"))
        ;
    }

}
