package com.example.juststickers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.juststickers.dto.ContactInfoDto;
import com.example.juststickers.dto.ContactRequestDto;
import com.example.juststickers.service.IContactService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {
    
    private final IContactService iContactService;
    private final ContactInfoDto contactInfoDto;
    @PostMapping
    public ResponseEntity<String> saveContact(@Valid @RequestBody ContactRequestDto contactRequestDto) {
        iContactService.saveContact(contactRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Request processed successfully");
    }
    
    @GetMapping
    public ResponseEntity<ContactInfoDto> getContactInfo(){
    	return ResponseEntity.status(HttpStatus.OK).body(contactInfoDto);
    }

}
