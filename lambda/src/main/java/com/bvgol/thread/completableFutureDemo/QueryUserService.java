package com.bvgol.thread.completableFutureDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author idea
 * @data 2020/2/22
 */
public class QueryUserService {
    private Supplier<QueryUtils> queryUtilsSupplier = QueryUtils::new;

    public UserInfo converUserInfo(UserInfo userInfo) {
        QuerySuppiler querySuppiler1 = new QuerySuppiler(userInfo.getCarId(), "car", queryUtilsSupplier.get());
        CompletableFuture<String> getCarDesc = CompletableFuture.supplyAsync(querySuppiler1);
//        getCarDesc.thenAccept(new Consumer<String>() {  //--1
//            @Override
//            public void accept(String carDesc) {
//                userInfo.setCarDes(carDesc);
//            }
//        });

        getCarDesc.thenAccept(userInfo::setCarDes);

        QuerySuppiler querySuppiler2 = new QuerySuppiler(userInfo.getHomeId(), "home", queryUtilsSupplier.get());
        CompletableFuture<String> getHomeDesc = CompletableFuture.supplyAsync(querySuppiler2);
        getHomeDesc.thenAccept(userInfo::setHomeDes);
//        getHomeDesc.thenAccept(new Consumer<String>() {  //--2
//            @Override
//            public void accept(String homeDesc) {
//                userInfo.setHomeDes(homeDesc);
//            }
//        });
        QuerySuppiler querySuppiler3 = new QuerySuppiler(userInfo.getJobId(), "job", queryUtilsSupplier.get());
        CompletableFuture<String> getJobDesc = CompletableFuture.supplyAsync(querySuppiler3);
        getJobDesc.thenAccept(userInfo::setJobDes);
//        getJobDesc.thenAccept(new Consumer<String>() {  //--3
//            @Override
//            public void accept(String jobDesc) {
//                userInfo.setJobDes(jobDesc);
//            }
//        });
        CompletableFuture<Void> getUserInfo = CompletableFuture.allOf(getCarDesc, getHomeDesc, getJobDesc);
//        getUserInfo.thenAccept(new Consumer<Void>() {
//            @Override
//            public void accept(Void result) {
//                System.out.println("全部完成查询" );
//            }
//        });
        getUserInfo.thenAccept(System.out::println);
        getUserInfo.join();  //--4
        return userInfo;
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        //多线程环境需要注意线程安全问题
        List<UserInfo> userInfoList = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i <= 20; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(i);
            userInfo.setName("username" + i);
            userInfo.setCarId(i);
            userInfo.setJobId(i);
            userInfo.setHomeId(i);
            userInfoList.add(userInfo);
        }
        //stream 查询一个用户花费3s  并行计算后一个用户1秒左右 查询21个用户花费21秒
        //parallelStream 速度更慢
        userInfoList.stream()
                .map(userInfo -> {
                    QueryUserService queryUserService = new QueryUserService();
                    userInfo = queryUserService.converUserInfo(userInfo);
                    return userInfo;
                }).collect(Collectors.toList());
        System.out.println("=============");
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
