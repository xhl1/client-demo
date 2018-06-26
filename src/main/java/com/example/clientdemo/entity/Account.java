package com.example.clientdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName: Account
 * @Package com.example.clientdemo.entity
 * @Description:
 * @Date 2018/5/31下午 2:01
 */
@Data
@Table(name = "t_enterprise_account")
public class Account implements Serializable{
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 账户类别 1 集团 2 企业
     */
    private Integer type;
    /**
     * 集团名称/公司名称ID
     */
    private String relatedId;
    /**
     * 用户名 唯一
     */
    private String userName;
    /**
     * 登录手机号
     */
    private String mobile;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 启用状态 1有效 2无效
     */
    private Integer status;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 修改时间
     */
    private long updateTime;
}
