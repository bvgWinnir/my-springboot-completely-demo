package com.bvgol.examples.myAnnotation;/**
 * @Classname BaseResponse
 * @Description TODO
 * @Date 2020/11/17 14:36
 * @Created by GUOCHEN
 */

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/17 14:36
 */
public class BaseResponse {
    private boolean success;
    private String responseMessage;
    private GlobalConstant responseCode;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseCode(GlobalConstant responseCode) {
        this.responseCode = responseCode;
    }

    public GlobalConstant getResponseCode() {
        return responseCode;
    }
}
