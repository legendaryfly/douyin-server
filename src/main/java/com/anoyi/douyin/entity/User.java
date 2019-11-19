package com.anoyi.douyin.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String username;
    
    private String avatar;
    
    private String name;
    
    private String title="";
    
    private int unreadCount=0;

    @JsonIgnore
    private String password;

    private Integer enable;

    @JsonIgnore
    private Date lastUpdatePwdTime;

    private List<Role> roles;

}