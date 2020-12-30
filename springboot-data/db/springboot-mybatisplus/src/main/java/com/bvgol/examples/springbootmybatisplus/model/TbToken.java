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
 * @Classname TbToken
 * @Description TODO
 * @Date 2020/12/30 15:04
 * @Created by GUOCHEN
 */

/**
 * 用户Token
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test.tb_token")
public class TbToken implements Serializable {
    @TableId(value = "user_id", type = IdType.INPUT)
    private Long userId;

    /**
     * token
     */
    @TableField(value = "token")
    private String token;

    /**
     * 过期时间
     */
    @TableField(value = "expire_time")
    private Date expireTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
