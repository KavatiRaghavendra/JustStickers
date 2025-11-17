package com.example.juststickers.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.juststickers.dto.ProductDto;

@Service
public interface IProductService {
	
	List<ProductDto> getProducts();

}
