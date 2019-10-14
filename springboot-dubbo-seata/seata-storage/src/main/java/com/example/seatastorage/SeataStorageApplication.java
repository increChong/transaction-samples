package com.example.seatastorage;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.seatastorage")
@MapperScan(basePackages = "com.example.seatastorage.mapper")
@EnableDubbo(scanBasePackages = "com.example.seatastorage.dubbo")
public class SeataStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataStorageApplication.class, args);
	}

}
