package com.company.LoginAndRegister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.company"})
@SpringBootApplication
public class LoginAndRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAndRegisterApplication.class, args);
	}

}
