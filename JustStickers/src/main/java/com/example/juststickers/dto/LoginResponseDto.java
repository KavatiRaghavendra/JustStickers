package com.example.juststickers.dto;


public record LoginResponseDto(String message, UserDto user, String jwtToken) {

}
