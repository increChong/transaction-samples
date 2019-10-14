package com.example.tcctransaction.account;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.example.tcctransaction.account")
@ImportResource({"classpath*:applicationContext-bean.xml"})
//@MapperScan(basePackages = "com.example.tcctransaction.account.mapper")
@EnableDubbo(scanBasePackages = "com.example.tcctransaction.account.dubbo")
public class TcctransactionAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcctransactionAccountApplication.class, args);
	}

}
