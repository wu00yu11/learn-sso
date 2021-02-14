package com.learn.sso.server.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_menu
 * @author 
 */
@Data
public class Menu implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单编号
     */
    private String menuCode;

    /**
     * 菜单地址
     */
    private String menuAddr;

    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    /**
     * 版本
     */
    private Integer version;

    private static final long serialVersionUID = 1L;
}