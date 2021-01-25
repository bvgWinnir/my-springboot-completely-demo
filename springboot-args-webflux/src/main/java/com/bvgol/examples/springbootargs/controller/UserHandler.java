package com.bvgol.examples.springbootargs.controller;

import com.bvgol.examples.springbootargs.pojo.WebfluxPoJo;
import com.bvgol.examples.springbootargs.service.WebfluxService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserHandler {
    private final WebfluxService webfluxService;

    public UserHandler(WebfluxService webfluxService) {
        this.webfluxService = webfluxService;
    }

    /**
     * 根据id查询
     */
    public Mono<ServerResponse> getUserById(ServerRequest request) {
        /* 获取id*/
        int userId = Integer.valueOf(request.pathVariable("id"));
        /* 空值处理*/
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        /* 调用service方法得到数据*/
        Mono<WebfluxPoJo> userMono = this.webfluxService.getOne(userId);
        /* userMono进行转换返回*/
        /* 使用Reactor操作符fluxMap*/
        return userMono
                .flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromObject(person)))
                .switchIfEmpty(notFound);
    }

    /**
     * 查询所有
     */
    public Mono<ServerResponse> getAllUser(ServerRequest request) {
        /* 调用service得到结果*/
        Flux<WebfluxPoJo> userFlux = this.webfluxService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userFlux, WebfluxPoJo.class);
    }

    /**
     * 添加
     */
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        /* 得到user对象*/
        Mono<WebfluxPoJo> userMono = request.bodyToMono(WebfluxPoJo.class);
        return ServerResponse.ok().build(this.webfluxService.addByPost(userMono));
    }
}
