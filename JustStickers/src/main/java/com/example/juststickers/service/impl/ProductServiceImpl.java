package com.example.juststickers.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.juststickers.Repo.ProductRepo;
import com.example.juststickers.dto.ProductDto;
import com.example.juststickers.entity.Product;
import com.example.juststickers.service.IProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{

	private final ProductRepo productRepo;
	
	@Cacheable("products")
	@Override
	public List<ProductDto> getProducts() {
		return productRepo.findAll().stream().map(this::transformToDTO).collect(Collectors.toList());
				
	}
	private ProductDto transformToDTO(Product product) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		productDto.setProductId(product.getId());
		return  productDto;
	}

}
