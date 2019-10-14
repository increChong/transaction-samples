package com.example.seataaccount;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.seataaccount")
@MapperScan(basePackages = "com.example.seataaccount.mapper")
@EnableDubbo(scanBasePackages = "com.example.seataaccount.dubbo")
public class SeataAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataAccountApplication.class, args);
	}

}
