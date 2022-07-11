package com.baekhwa.song;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class BaekhwaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaekhwaApplication.class, args);
	}
	/*
	@Bean
	HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	//applocation.properties 에 설정가능
	//spring.mvc.hiddenmethod.filter.enabled=true
	*/

}
