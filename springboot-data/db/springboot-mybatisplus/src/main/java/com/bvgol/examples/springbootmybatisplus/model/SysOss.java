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

/**
 * @Classname SysOss
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */

/**
 * 文件上传
 */
@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test.sys_oss")
public class SysOss implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * URL地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private Date createDate;

    private static final long serialVersionUID = 1L;
}
