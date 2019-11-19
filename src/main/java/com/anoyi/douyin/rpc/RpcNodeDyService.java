package com.anoyi.douyin.rpc;

import com.anoyi.grpc.annotation.GrpcService;
import com.anoyi.grpc.constant.SerializeType;

/**
 * NodeJS 提供的签名算法服务
 */
@GrpcService(server = "micro-node-douyin", serialization = SerializeType.FASTJSON)
public interface RpcNodeDyService {

    /**
     * 获取签名
     * @param id 用户ID
     * @param script 脚本
     * @return 签名
     */
    String generateSignature(String id, String script);

}
