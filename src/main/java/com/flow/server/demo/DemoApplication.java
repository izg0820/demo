package com.flow.server.demo;

import com.flow.server.demo.utils.InitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		InitService initService = new InitService();
		initService.init();
	}

}
