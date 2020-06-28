package com.bvgol.springbootjapiDocs.form;

public class AdminForm {

    private String name; //名字
    private String password; //密码

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}