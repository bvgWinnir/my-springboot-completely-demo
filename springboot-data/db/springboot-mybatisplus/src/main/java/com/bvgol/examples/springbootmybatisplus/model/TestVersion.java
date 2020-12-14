package com.bvgol.examples.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * @Classname TestVersion
 * @Description TODO
 * @Date 2020/10/27 13:34
 * @Created by GUOCHEN
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "testVersion")
public class TestVersion implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @Version
    @TableField(value = "version")
    private Integer version;


    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
