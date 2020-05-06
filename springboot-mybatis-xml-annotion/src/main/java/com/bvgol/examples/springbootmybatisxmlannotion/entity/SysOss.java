package com.bvgol.examples.springbootmybatisxmlannotion.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 文件上传(SysOss)实体类
 *
 * @author makejava
 * @since 2020-05-03 21:55:32
 */
public class SysOss implements Serializable {
    private static final long serialVersionUID = 136063433207516074L;
    
    private Long id;
    /**
    * URL地址
    */
    private String url;
    /**
    * 创建时间
    */
    private Date createDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}