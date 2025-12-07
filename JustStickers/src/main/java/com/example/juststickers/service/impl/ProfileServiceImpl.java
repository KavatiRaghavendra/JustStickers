package com.example.juststickers.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.juststickers.Repo.CustomerRepository;
import com.example.juststickers.dto.AddressDto;
import com.example.juststickers.dto.ProductDto;
import com.example.juststickers.dto.ProfileRequestDto;
import com.example.juststickers.dto.ProfileResponseDto;
import com.example.juststickers.entity.Address;
import com.example.juststickers.entity.Customer;
import com.example.juststickers.service.IProductService;
import com.example.juststickers.service.IProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements IProfileService{
	  
	private final CustomerRepository customerRepository;

	@Override
	public ProfileResponseDto getProfile() {
		 Customer customer = getAuthenticatedCustomer();
	       return mapCustomerToProfileResponseDto(customer);

	}
	
	 private ProfileResponseDto mapCustomerToProfileResponseDto(Customer customer) {
		ProfileResponseDto profileResponseDto = new ProfileResponseDto();
		BeanUtils.copyProperties(customer, profileResponseDto);
		 if (customer.getAddress() != null) {
	            AddressDto addressDto = new AddressDto();
	            BeanUtils.copyProperties(customer.getAddress(), addressDto);
	            profileResponseDto.setAddress(addressDto);
	        }
	        return profileResponseDto;
	}

	public Customer getAuthenticatedCustomer() {
	        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
	        String email = authentication.getName();
	        return customerRepository.findByEmail(email).
	                orElseThrow(() -> new UsernameNotFoundException("User not found"));
	    }

	@Override
	public ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto) {
		Customer customer = getAuthenticatedCustomer();
        boolean isEmailUpdated = !customer.getEmail().equals(profileRequestDto.getEmail().trim());
        BeanUtils.copyProperties(profileRequestDto, customer);
        Address address = customer.getAddress();
        if(address == null)
        {
        	address = new Address();
            address.setCustomer(customer);
        }
        address.setStreet(profileRequestDto.getStreet());
        address.setCity(profileRequestDto.getCity());
        address.setState(profileRequestDto.getState());
        address.setPostalCode(profileRequestDto.getPostalCode());
        address.setCountry(profileRequestDto.getCountry());
        customer.setAddress(address);
        customer = customerRepository.save(customer);
        ProfileResponseDto profileResponseDto = mapCustomerToProfileResponseDto(customer);
        profileResponseDto.setEmailUpdated(isEmailUpdated);
        return profileResponseDto;	
	}
	

}
