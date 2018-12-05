package com.nguyenvulong2002.bookclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class EBookWebAppApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EBookWebAppApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EBookWebAppApplication.class, args);
	}
}
