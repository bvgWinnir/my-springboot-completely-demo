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
 * @Classname SysConfig
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */

/**
 * 系统配置信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test.sys_config")
public class SysConfig implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * key
     */
    @TableField(value = "param_key")
    private String paramKey;

    /**
     * value
     */
    @TableField(value = "param_value")
    private String paramValue;

    /**
     * 状态   0：隐藏   1：显示
     */
    @TableField(value = "status")
    private Byte status;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    private static final long serialVersionUID = 1L;
}
