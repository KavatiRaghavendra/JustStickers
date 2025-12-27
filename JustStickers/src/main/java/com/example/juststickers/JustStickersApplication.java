package com.example.juststickers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.juststickers.dto.ContactInfoDto;


@SpringBootApplication
@EnableCaching
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableConfigurationProperties(value = (ContactInfoDto.class))
public class JustStickersApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustStickersApplication.class, args);
	}
  
}
