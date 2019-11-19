package com.anoyi.douyin.entity;

import lombok.Data;

@Data
public class Resp<T> {

    private Integer code;
    private String message;
    private T data;

}
