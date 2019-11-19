package com.anoyi.douyin.entity;

public class RespFactory {

    private static final Integer CODE_SUCCESS = 0;
    private static final Integer CODE_ERROR = -1;
    private static final Integer CODE_TOKEN_ERROR = 401;
    private static final Integer CODE_FORBIDDEN_ERROR = 403;

    public static <T> Resp<T> success(T data) {
        Resp<T> tResp = new Resp<>();
        tResp.setCode(CODE_SUCCESS);
        tResp.setMessage("success");
        tResp.setData(data);
        return tResp;
    }

    public static Resp<Object> error(String msg) {
        Resp<Object> tResp = new Resp<>();
        tResp.setCode(CODE_ERROR);
        tResp.setMessage(msg);
        return tResp;
    }

    public static Resp<Object> tokenError() {
        Resp<Object> tResp = new Resp<>();
        tResp.setCode(CODE_TOKEN_ERROR);
        tResp.setMessage("token 校验失败");
        return tResp;
    }

    public static Resp<Object> forbiddenError() {
        Resp<Object> tResp = new Resp<>();
        tResp.setCode(CODE_FORBIDDEN_ERROR);
        tResp.setMessage("访问受限");
        return tResp;
    }
}
