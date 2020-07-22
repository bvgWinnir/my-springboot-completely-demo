package com.bvgol.examples.springbootdocker.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cron")
public class Cron implements Serializable {
    @TableId(value = "cron_id", type = IdType.AUTO)
    private Long cronId;

    @TableField(value = "cron")
    private String cron;

    private static final long serialVersionUID = 1L;

}
