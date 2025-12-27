package com.example.juststickers.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.juststickers.dto.OrderPlacedDetailsDTO;
import com.example.juststickers.dto.OrderRequestDto;
import com.example.juststickers.dto.OrderResponseDto;
import com.example.juststickers.service.IOrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
	
	private final IOrderService iOrderService;
	
	@PostMapping
	public ResponseEntity<String>  orderplaced( @RequestBody OrderRequestDto requestDto){
		log.info("Order placed" +  requestDto.toString());
		iOrderService.createOrder(requestDto);
		return  ResponseEntity.ok().body("Sucess");
		
	}
	
	@GetMapping
	public ResponseEntity<List<OrderResponseDto>>  Getorder(){
		
		return ResponseEntity.ok(iOrderService.getCustomerOrders());
		
	}
	

	
}
