package com.bvgol.springbootjapiDocs.form;

import javax.validation.constraints.NotNull;

/**
 * @author guochen
 * @Title: UserListForm
 * @Package
 * @Description:
 * @date 2020/6/289:59
 */
public class UserListForm extends PageForm {
    private Integer status; //用户状态
    @NotNull
    private String name; //用户名
}
