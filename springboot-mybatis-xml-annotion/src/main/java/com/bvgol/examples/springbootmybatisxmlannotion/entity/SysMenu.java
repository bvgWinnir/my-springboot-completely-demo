package com.bvgol.examples.springbootmybatisxmlannotion.entity;

import java.io.Serializable;

/**
 * 菜单管理(SysMenu)实体类
 *
 * @author makejava
 * @since 2020-05-03 21:55:32
 */
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 698630188842641727L;
    
    private Long menuId;
    /**
    * 父菜单ID，一级菜单为0
    */
    private Long parentId;
    /**
    * 菜单名称
    */
    private String name;
    /**
    * 菜单URL
    */
    private String url;
    /**
    * 授权(多个用逗号分隔，如：user:list,user:create)
    */
    private String perms;
    /**
    * 类型   0：目录   1：菜单   2：按钮
    */
    private Integer type;
    /**
    * 菜单图标
    */
    private String icon;
    /**
    * 排序
    */
    private Integer orderNum;


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

}