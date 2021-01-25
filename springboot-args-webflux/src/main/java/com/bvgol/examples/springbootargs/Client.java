package com.bvgol.examples.springbootargs;

import com.bvgol.examples.springbootargs.pojo.WebfluxPoJo;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Client {
    public static void main(String[] args) {
        /* 调用服务器地址*/
        WebClient webClient = WebClient.create("http://127.0.0.1:8080");

        /* 根据ID查询*/
        String id = "1";
        WebfluxPoJo userResult = webClient.get().uri("/user/{id}", id)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(WebfluxPoJo.class)
                .block();
        System.out.println(userResult.getName());

        /* 查询所有*/
        Flux<WebfluxPoJo> results = webClient.get().uri("/user").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(WebfluxPoJo.class);
        results.map(stu -> stu.getName()).buffer().doOnNext(System.out::println).blockFirst();
    }
}
