package com.example.juststickers.service;

import com.example.juststickers.dto.ProfileRequestDto;
import com.example.juststickers.dto.ProfileResponseDto;

public interface IProfileService {

	ProfileResponseDto getProfile();

	ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto);
}
