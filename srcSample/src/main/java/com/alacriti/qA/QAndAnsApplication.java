package com.alacriti.qA;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QAndAnsApplication {

	public static void main(String[] args) {
		System.out.println("starting main application ");
		SpringApplication.run(QAndAnsApplication.class, args);
	}
	
	@Bean
	FilterRegistrationBean myFilterRegistration() {
		System.out.println("Filter");
	
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new AppLoginFilter());
		frb.setUrlPatterns(Arrays.asList("/*"));
		return frb;
	}
}
