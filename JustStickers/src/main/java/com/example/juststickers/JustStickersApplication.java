package com.example.juststickers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableCaching
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class JustStickersApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustStickersApplication.class, args);
	}
  
}
