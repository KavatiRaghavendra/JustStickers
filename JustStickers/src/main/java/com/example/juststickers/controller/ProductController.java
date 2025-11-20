package com.example.juststickers.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.juststickers.dto.ProductDto;
import com.example.juststickers.service.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/products")
//@CrossOrigin(origins = "http://localhost:5174") // allow only this origin
@RequiredArgsConstructor
public class ProductController {
	
	private final IProductService iProductService; 

	  @GetMapping
	  public ResponseEntity<List<ProductDto>> Products()
	  {
		   List<ProductDto> productList = iProductService.getProducts();

		  return ResponseEntity.ok().body(productList);
	  }
}
