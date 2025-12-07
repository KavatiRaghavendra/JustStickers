package com.example.juststickers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.juststickers.dto.ProfileRequestDto;
import com.example.juststickers.dto.ProfileResponseDto;
import com.example.juststickers.service.IProfileService;

import lombok.RequiredArgsConstructor;
@RequestMapping("/api/v1/profile")
@RestController
@RequiredArgsConstructor
public class ProfileController {
	
	 private final IProfileService iProfileService;

	@GetMapping
	public ResponseEntity<ProfileResponseDto> getProfile(){
		   ProfileResponseDto responseDto = iProfileService.getProfile();
	        return ResponseEntity.ok(responseDto);
	 
	}
	
	 @PutMapping
	    public ResponseEntity<ProfileResponseDto> updateProfile(
	            @Validated @RequestBody ProfileRequestDto profileRequestDto) {
	        ProfileResponseDto responseDto = iProfileService.updateProfile(profileRequestDto);
	        return ResponseEntity.ok(responseDto);
	    }

}
