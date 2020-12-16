package com.ENTER;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;




@ServletComponentScan
@SpringBootApplication
public class EnterApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(EnterApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EnterApplication.class, args);
	}

}
