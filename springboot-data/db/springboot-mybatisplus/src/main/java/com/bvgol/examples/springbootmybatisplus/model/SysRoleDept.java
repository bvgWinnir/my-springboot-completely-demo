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
 * @Classname SysRoleDept
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */

/**
 * 角色与部门对应关系
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test.sys_role_dept")
public class SysRoleDept implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 部门ID
     */
    @TableField(value = "dept_id")
    private Long deptId;

    private static final long serialVersionUID = 1L;
}
