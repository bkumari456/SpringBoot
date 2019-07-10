package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringWebMvcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebMvcAppApplication.class, args);
	}
	
	@Bean
	public CacheManager cm() {
		ConcurrentMapCacheManager cm=new ConcurrentMapCacheManager("employee");
		return cm;
	}
	
	
	
	
	
}
