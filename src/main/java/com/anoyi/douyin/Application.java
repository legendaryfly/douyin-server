package com.anoyi.douyin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.anoyi.grpc.annotation.GrpcServiceScan;

@SpringBootApplication
@GrpcServiceScan(packages = "com.anoyi.douyin.rpc")
@MapperScan("com.anoyi.douyin.mapper")
@ComponentScan
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
