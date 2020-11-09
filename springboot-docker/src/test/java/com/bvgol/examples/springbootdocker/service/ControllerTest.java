package com.bvgol.examples.springbootdocker.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testDemo() {
    }

    //GET请求测试
    @Test
    public void get() throws Exception {
        Map<String, String> multiValueMap = new HashMap<>();
        multiValueMap.put("username", "Java技术栈");
        ActResult result = testRestTemplate.getForObject("/test/getUser?username={username}", ActResult.class, multiValueMap);
        Assert.assertEquals(result.getCode(), 0);
    }

    //POST请求测试
    @Test
    public void post() throws Exception {
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username", "Java技术栈");
        ActResult result = testRestTemplate.postForObject("/test/post", multiValueMap, ActResult.class);
        Assert.assertEquals(result.getCode(), 0);
    }

    //文件上传测试
    @Test
    public void upload() throws Exception {
        Resource resource = new FileSystemResource("/home/javastack/test.jar");
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("username", "Java技术栈");
        multiValueMap.add("files", resource);
        ActResult result = testRestTemplate.postForObject("/test/upload", multiValueMap, ActResult.class);
        Assert.assertEquals(result.getCode(), 0);
    }

    //文件下载测试
     @Test
    public void download() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", "javastack");
        HttpEntity formEntity = new HttpEntity(headers);
        String[] urlVariables = new String[]{"admin"};
        ResponseEntity<byte[]> response = testRestTemplate.exchange("/test/download?username={1}", HttpMethod.GET, formEntity, byte[].class, urlVariables);
        if (response.getStatusCode() == HttpStatus.OK) {
            //Files.write(response.getBody(), new File("/home/javastack/test.jar"));
        }
    }
}
