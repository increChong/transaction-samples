package com.example.tcctransaction.storage;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.example.tcctransaction.storage")
@ImportResource({"classpath*:applicationContext-bean.xml"})
//@MapperScan(basePackages = "com.example.tcctransaction.storage.mapper")
@EnableDubbo(scanBasePackages = "com.example.tcctransaction.storage.dubbo")
public class TcctransactionStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcctransactionStorageApplication.class, args);
	}

}
