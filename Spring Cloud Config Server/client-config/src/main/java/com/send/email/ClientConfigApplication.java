package com.send.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ClientConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientConfigApplication.class, args);
	}

}
