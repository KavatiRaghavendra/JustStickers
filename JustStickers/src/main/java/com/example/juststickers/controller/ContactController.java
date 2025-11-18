package com.example.juststickers.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public record ContactController() {
    
}
