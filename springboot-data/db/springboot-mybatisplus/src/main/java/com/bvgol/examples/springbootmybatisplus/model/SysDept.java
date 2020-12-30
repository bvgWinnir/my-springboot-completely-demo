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
 * @Classname SysDept
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */

/**
 * 部门管理
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test.sys_dept")
public class SysDept implements Serializable {
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;

    /**
     * 上级部门ID，一级部门为0
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 部门名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 排序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableField(value = "del_flag")
    private Byte delFlag;

    private static final long serialVersionUID = 1L;
}
