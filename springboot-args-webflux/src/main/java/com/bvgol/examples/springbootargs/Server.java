//package com.bvgol.examples.springbootargs;
//
//import com.bvgol.examples.springbootargs.controller.UserHandler;
//
//import com.bvgol.examples.springbootargs.service.WebfluxServiceImpl;
//
//import org.springframework.http.server.reactive.HttpHandler;
//import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.RouterFunctions;
//import org.springframework.web.servlet.function.ServerResponse;
//import reactor.netty.http.server.HttpServer;
//
//import java.io.IOException;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.web.servlet.function.RequestPredicates.GET;
//import static org.springframework.web.servlet.function.RequestPredicates.accept;
//
//public class Server {
//    /** 创建Router路由*/
//    public RouterFunction<ServerResponse> routerFunction(){
//        /* 创建hanler对象*/
//        WebfluxServiceImpl userService = new WebfluxServiceImpl();
//        UserHandler handler = new UserHandler(userService);
//        /* 设置路由*/
//        return RouterFunctions.route(
//                GET("/user/{id}").and(accept(APPLICATION_JSON)),handler::getUserById)
//                .andRoute(GET("/user").and(accept(APPLICATION_JSON)),handler::getAllUser);
//
//    }
//
//    /** 创建服务器完成配置*/
//    public void createReactorServer() throws IOException {
//        /*路由和handler适配*/
//        RouterFunction<ServerResponse> route = routerFunction();
//        HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);
//        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
//
//        /* 创建服务器*/
//        HttpServer httpServer = HttpServer.create();
//        httpServer.handle(adapter).bindNow();
//    }
//
//    public static void main(String[] args) throws Exception {
//        Server server = new Server();
//        server.createReactorServer();
//        System.out.println("enter to exit");
//        System.in.read();
//    }
//}
