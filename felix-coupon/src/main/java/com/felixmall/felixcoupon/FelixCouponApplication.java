package com.felixmall.felixcoupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@MapperScan("com.felixmall.felixcoupon.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class FelixCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(FelixCouponApplication.class, args);
    }

}
