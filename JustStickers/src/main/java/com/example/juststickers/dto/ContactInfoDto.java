package com.example.juststickers.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("contact")
public record ContactInfoDto (String ContactNo,String Email,String Address){

}
