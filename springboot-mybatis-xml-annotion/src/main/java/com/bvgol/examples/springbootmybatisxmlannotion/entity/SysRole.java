package com.bvgol.examples.springbootmybatisxmlannotion.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色(SysRole)实体类
 *
 * @author makejava
 * @since 2020-05-03 21:55:33
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 926180748486501213L;
    
    private Long roleId;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 备注
    */
    private String remark;
    /**
    * 部门ID
    */
    private Long deptId;
    /**
    * 创建时间
    */
    private Date createTime;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", deptId=" + deptId +
                ", createTime=" + createTime +
                '}';
    }
}