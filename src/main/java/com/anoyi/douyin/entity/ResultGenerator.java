package com.anoyi.douyin.entity;

import org.springframework.http.HttpStatus;

/**
 * 响应结果生成工具
 *
 */
public class ResultGenerator {
	//默认消息区
    private static final String DEFAULT_OK_MESSAGE = "OK";
    private static final String DEFAULT_UNAUTHORIZED_MESSAGE = "需要授权";
    private static final String DEFAULT_METHOD_NOT_ALLOWED_MESSAGE = "请求方法不正确";
    
    //自定义消息区

    public static Result genOkResult() {
        return new Result
                .Builder(HttpStatus.OK.value())
                .msg(DEFAULT_OK_MESSAGE)
                .build();
    }

    public static Result genOkResult(final Object data) {
        return new Result
                .Builder(HttpStatus.OK.value())
                .msg(DEFAULT_OK_MESSAGE)
                .data(data)
                .build();
    }

    public static Result genFailedResult(final String msg) {
        return new Result
                .Builder(HttpStatus.BAD_REQUEST.value())
                .msg(msg)
                .build();
    }

    public static Result genMethodErrorResult() {
        return new Result
                .Builder(HttpStatus.METHOD_NOT_ALLOWED.value())
                .msg(DEFAULT_METHOD_NOT_ALLOWED_MESSAGE)
                .build();
    }

    public static Result genUnauthorizedResult() {
        return new Result
                .Builder(HttpStatus.UNAUTHORIZED.value())
                .msg(DEFAULT_UNAUTHORIZED_MESSAGE)
                .build();
    }

    public static Result genUnauthorizedResult(final String msg) {
        return new Result
                .Builder(HttpStatus.UNAUTHORIZED.value())
                .msg(msg)
                .build();
    }

    public static Result genInternalServerErrorResult(final String url) {
        return new Result
                .Builder(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .msg("API [" + url + "] 内部服务器错误。")
                .build();
    }
}
