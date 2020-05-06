package com.bvgol.examples.springbootmybatisxmlannotion.entity;

import java.io.Serializable;

/**
 * 部门管理(SysDept)实体类
 *
 * @author makejava
 * @since 2020-05-03 21:55:22
 */
public class SysDept implements Serializable {
    private static final long serialVersionUID = 453139579068912873L;
    
    private Long deptId;
    /**
    * 上级部门ID，一级部门为0
    */
    private Long parentId;
    /**
    * 部门名称
    */
    private String name;
    /**
    * 排序
    */
    private Integer orderNum;
    /**
    * 是否删除  -1：已删除  0：正常
    */
    private Object delFlag;


    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Object getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Object delFlag) {
        this.delFlag = delFlag;
    }

}