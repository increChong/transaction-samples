package com.example.seatabusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.example.seatabusiness")
@ImportResource({"classpath*:dubbo-business.xml"})
public class SeataBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataBusinessApplication.class, args);
	}

}
