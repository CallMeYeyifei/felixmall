package com.felixmall.felixware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.felixmall.felixware.dao")
@EnableDiscoveryClient
public class FelixWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(FelixWareApplication.class, args);
	}

}
