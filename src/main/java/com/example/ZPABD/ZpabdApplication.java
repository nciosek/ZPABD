package com.example.ZPABD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZpabdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZpabdApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		filterRegistrationBean().setFilter(new JwtFilter());
		filterRegistrationBean().setUrlPatterns(java.util.Collections.singleton("/api/"));
		return filterRegistrationBean();
	}
}
