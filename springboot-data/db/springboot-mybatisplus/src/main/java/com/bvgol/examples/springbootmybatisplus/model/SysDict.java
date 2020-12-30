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

/**
 * @Classname SysDict
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */

/**
 * 数据字典表
 */
@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test.sys_dict")
public class SysDict implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 字典名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 字典类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 字典码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 字典值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 删除标记  -1：已删除  0：正常
     */
    @TableField(value = "del_flag")
    private Byte delFlag;

    private static final long serialVersionUID = 1L;
}
