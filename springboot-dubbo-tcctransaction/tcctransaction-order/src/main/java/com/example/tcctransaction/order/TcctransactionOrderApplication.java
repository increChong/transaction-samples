package com.example.tcctransaction.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.example.tcctransaction.order")
@ImportResource({"classpath*:applicationContext-bean.xml"})
//@MapperScan(basePackages = "com.example.tcctransaction.order.mapper")
@EnableDubbo(scanBasePackages = "com.example.tcctransaction.order.dubbo")
public class TcctransactionOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcctransactionOrderApplication.class, args);
	}

}
