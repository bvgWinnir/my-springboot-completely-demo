package com.bvgol.examples.springbootargs.service;/**
 * @Classname WebfluxService
 * @Description TODO
 * @Date 2021/1/25 15:38
 * @Created by GUOCHEN
 */

import com.bvgol.examples.springbootargs.pojo.WebfluxPoJo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: my-springboot-completely
 * @description: webflux 接口
 * @author: GUOCHEN
 * @create: 2021/01/25 15:38
 */
public interface WebfluxService {

    Mono<WebfluxPoJo> getOne(Integer id);

    Flux<WebfluxPoJo> getAll();

    Mono<Void> addByPost(Mono<WebfluxPoJo> obj);

}
