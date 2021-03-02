package com.felixmall.felixorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.felixmall.felixorder.dao")
public class FelixOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FelixOrderApplication.class, args);
	}

}
