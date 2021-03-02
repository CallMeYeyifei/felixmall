package com.felixmall.felixproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*引入依赖mybatis-plus-boot-starter
		<dependency>
		<groupId>com.baomidou</groupId>
		<artifactId>mybatis-plus-boot-starter</artifactId>
		<version>3.3.1</version>
		</dependency>
		第二步 引入 mysql-connector-java
		配置数据源
			导入数据库驱动
			配置application.yml文件
		配置mybatis-plus
			配置mapperScan
			告诉mybatis-plus sql映射文件在哪里
		*/
@MapperScan("com.felixmall.felixproduct.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class FelixProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(FelixProductApplication.class, args);
	}

}
