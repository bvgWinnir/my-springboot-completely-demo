package com.bvgol.springbootjapiDocs.form;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author yeguozhong yedaxia.github.com
 */
public class UserForm {
    /**
     * 用户ID
     */
    private Long id;
    @NotBlank
    private String name; //用户名
    @NotNull
    private Long phone; //电话
    @NotEmpty
    private String avatar; // 头像
    private Byte gender; //性别
}
