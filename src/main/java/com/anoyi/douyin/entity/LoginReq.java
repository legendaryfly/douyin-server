package com.anoyi.douyin.entity;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginReq {

    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;

}
