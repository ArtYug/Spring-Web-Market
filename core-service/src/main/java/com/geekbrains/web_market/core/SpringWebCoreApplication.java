package com.geekbrains.web_market.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:./secret.properties")
public class SpringWebCoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebCoreApplication.class, args);
	}
}
