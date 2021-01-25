package com.bvgol.examples.websocket.controller;/**
 * @Classname MyMessage
 * @Description TODO
 * @Date 2021/1/25 15:55
 * @Created by GUOCHEN
 */

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2021/01/25 15:55
 */
public class MyMessage {
    private String userId;
    private String message;

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
