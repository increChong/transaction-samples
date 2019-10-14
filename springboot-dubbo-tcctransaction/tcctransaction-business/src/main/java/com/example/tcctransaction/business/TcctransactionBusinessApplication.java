package com.example.tcctransaction.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.example.tcctransaction.business")
@ImportResource({"classpath*:dubbo-business.xml","classpath*:applicationContext-bean.xml"})
public class TcctransactionBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcctransactionBusinessApplication.class, args);
	}

}
