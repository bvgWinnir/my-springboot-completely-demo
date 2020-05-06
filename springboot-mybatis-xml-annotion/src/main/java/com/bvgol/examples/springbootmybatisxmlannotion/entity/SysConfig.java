package com.bvgol.examples.springbootmybatisxmlannotion.entity;

import java.io.Serializable;

/**
 * 系统配置信息表(SysConfig)实体类
 *
 * @author makejava
 * @since 2020-05-03 21:55:16
 */
public class SysConfig implements Serializable {
    private static final long serialVersionUID = -36389119048929539L;
    
    private Long id;
    /**
    * key
    */
    private String paramKey;
    /**
    * value
    */
    private String paramValue;
    /**
    * 状态   0：隐藏   1：显示
    */
    private Object status;
    /**
    * 备注
    */
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}