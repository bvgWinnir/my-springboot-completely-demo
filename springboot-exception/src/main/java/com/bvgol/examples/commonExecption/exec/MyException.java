package com.bvgol.examples.commonExecption.exec;

public class MyException extends RuntimeException {

    public MyException(String message) {

        super(message);

    }

    private Integer code;
    private String msg;

    public MyException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MyException() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}