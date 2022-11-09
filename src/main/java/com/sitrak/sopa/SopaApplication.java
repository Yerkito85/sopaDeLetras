package com.sitrak.sopa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan //(basePackages = {"com.sitrak.sopa"})
@SpringBootApplication
public class SopaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SopaApplication.class, args);
	}

}
