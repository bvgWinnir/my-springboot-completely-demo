package com.bvgol.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author guochen
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/2916:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    /**
     * 姓名
     */
    private String name;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别 男true 女false
     */
    private Boolean sex;
    /**
     * 分数
     */
    private Double score;
    /**
     * 年龄
     */
    private Integer age;

}
