package com.example.seataorder;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.seataorder")
@MapperScan(basePackages = "com.example.seataorder.mapper")
@EnableDubbo(scanBasePackages = "com.example.seataorder.dubbo")
public class SeataOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataOrderApplication.class, args);
	}

}
