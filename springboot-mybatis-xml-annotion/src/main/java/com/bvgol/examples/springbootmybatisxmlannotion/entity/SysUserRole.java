package com.bvgol.examples.springbootmybatisxmlannotion.entity;

import java.io.Serializable;

/**
 * 用户与角色对应关系(SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-05-03 21:55:36
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -47845088110205595L;
    
    private Long id;
    /**
    * 用户ID
    */
    private Long userId;
    /**
    * 角色ID
    */
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}