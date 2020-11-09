package com.bvgol.examples.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test_bit")
public class TestBit implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "sex")
    private Boolean sex;

    @TableField(value = "name")
    private String name;

    @TableField(value = "brithday")
    private Date brithday;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_SEX = "sex";

    public static final String COL_NAME = "name";

    public static final String COL_BRITHDAY = "brithday";
}
