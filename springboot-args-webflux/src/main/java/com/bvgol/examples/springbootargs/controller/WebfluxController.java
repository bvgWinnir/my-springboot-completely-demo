package com.bvgol.examples.springbootargs.controller;/**
 * @Classname WebfluxController
 * @Description TODO
 * @Date 2021/1/25 11:11
 * @Created by GUOCHEN
 */

import com.bvgol.examples.springbootargs.pojo.WebfluxPoJo;
import com.bvgol.examples.springbootargs.service.WebfluxService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2021/01/25 11:11
 */
@RestController
@AllArgsConstructor
public class WebfluxController {

    private WebfluxService webfluxService;

    /**
     * @param
     * @return
     * @Classname WebfluxController
     * @Description 注解写法:根据id 查一个
     * @Date 2021/1/25 11:17
     * @auther by GUOCHEN
     */
    @GetMapping("get/{id}")
    public Mono<WebfluxPoJo> get(@PathVariable("id") Integer id) {
        return webfluxService.getOne(id);
    }

    /**
     * @param
     * @return
     * @Classname WebfluxController
     * @Description 注解写法:查所有
     * @Date 2021/1/25 11:20
     * @auther by GUOCHEN
     */
    @GetMapping("get/all")
    public Flux<WebfluxPoJo> get() {
        return webfluxService.getAll();
    }

    /**
     * @param
     * @param obj
     * @return
     * @Classname
     * @Description 注解写法:添加/修改
     * @Date 2021/1/25 11:22
     * @auther by GUOCHEN
     */
    @PostMapping("addObject")
    public Mono<Void> post(@RequestBody Mono<WebfluxPoJo> obj) {
        return webfluxService.addByPost(obj);
    }

    /**
     * @Classname WebfluxController
     * @param
     * @return
     * @Description 函数式写法:查一个
     * @Date 2021/1/25 11:35
     * @auther by GUOCHEN
     */
//       @GetMapping("get/handler/{id}")
//       public Mono<ServerRequest> get(ServerRequest request){
//        Integer id = Integer.valueOf(request.pathVariable("id"));
//           Mono<WebfluxPoJo> webfluxPoJoMono = Mono.justOrEmpty(map.get(id));
//
//           return webfluxPoJoMono.flatMap(webfluxPoJo -> {
//               ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(webfluxPoJo))).switchIfEmpty((Mono<ServerResponse>)ServerResponse.notFound().build());
//           });
//       }

    /**
     * @Classname WebfluxController
     * @param
     * @return
     * @Description TODO
     * @Date 2021/1/25 13:22
     * @auther by GUOCHEN
     */
//     @GetMapping("get/{id}")
//     public Mono<ServerResponse> getAll(){
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Flux.fromIterable(map.values()),WebfluxPoJo.class);
//     }

    /**
     * @Classname
     * @param
     * @return
     * @Description TODO
     * @Date 2021/1/25 13:26
     * @auther by GUOCHEN
     */
//    @PostMapping("post")
//    public Mono<ServerResponse> post(ServerRequest request) throws ServletException, IOException {
//        Mono<WebfluxPoJo> obj = request.body(WebfluxPoJo.class);
//        obj.doOnNext(webfluxPoJo -> {
//            map.put(map.size()+1,webfluxPoJo);
//        }).thenEmpty(Mono.empty())
//        return ServerResponse.ok().build();
//    }

}
