package com.example.juststickers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderPlacedDetailsDTO {

	
	@NotBlank(message = "Name is required")

    @Size(min = 5, max = 30, message = "The length of the name should be between 5 and 100 characters")
    private String name;
	
	 @NotBlank(message = "Email is required")
	 @Email(message = "Email address must be a valid value")
	 private String email;

	 @NotBlank(message = "Mobile Number is required")
     @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be exactly 10 digits")
     private String mobileNumber;
	 
	 @NotBlank(message = "Address is required")
     @Size(min = 5, max = 100, message = "address must be between 5 to 100 digits")
     private String address;
	
	 @NotBlank(message = "Payment is required")
     private String payment;
	 
	 
}
