package com.bvgol.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname Druid
 * @Description TODO
 * @Date 2020/11/9 14:11
 * @Created by GUOCHEN
 */

/**
 * 德鲁伊测试
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Druid implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    private String name;

    /**
     * java8 的时间
     */
    private Date localdate;

    private Boolean sex;

    /**
     * 乐观锁预留
     */
    private Integer version;

    private static final long serialVersionUID = 1L;
}
