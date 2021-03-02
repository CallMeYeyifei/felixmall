package com.felixmall.felixmember;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.felixmall.felixmember.feigh")
@MapperScan("com.felixmall.felixmember.dao")
public class FelixMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(FelixMemberApplication.class, args);
    }

}
