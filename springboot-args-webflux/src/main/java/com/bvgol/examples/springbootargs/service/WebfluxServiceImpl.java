package com.bvgol.examples.springbootargs.service;/**
 * @Classname WebfluxServiceImpl
 * @Description TODO
 * @Date 2021/1/25 15:38
 * @Created by GUOCHEN
 */

import com.bvgol.examples.springbootargs.pojo.WebfluxPoJo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2021/01/25 15:38
 */
@Service
public class WebfluxServiceImpl implements WebfluxService {
    private Map<Integer, WebfluxPoJo> map = new HashMap<>();

    public WebfluxServiceImpl() {
        for (int i = 0; i < 11; i++) {
            map.put(i, WebfluxPoJo.builder().id(i).name("韩梅梅-" + i).birthday(new Date()).build());
        }
    }

    @Override
    public Mono<WebfluxPoJo> getOne(Integer id) {
        return Mono.justOrEmpty(map.get(id));
    }

    @Override
    public Flux<WebfluxPoJo> getAll() {
        return Flux.fromIterable(map.values());
    }

    @Override
    public Mono<Void> addByPost(Mono<WebfluxPoJo> obj) {
        return obj.doOnNext(webfluxPoJo -> {
            map.put(map.size() + 1, webfluxPoJo);
        }).thenEmpty(Mono.empty());
    }
}
