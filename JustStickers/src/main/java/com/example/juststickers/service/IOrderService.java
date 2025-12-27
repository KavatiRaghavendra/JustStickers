package com.example.juststickers.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.juststickers.dto.OrderRequestDto;
import com.example.juststickers.dto.OrderResponseDto;

@Service
public interface IOrderService {

    void createOrder(OrderRequestDto orderRequest);

	List<OrderResponseDto> getCustomerOrders();

	List<OrderResponseDto> getAllPendingOrders();

	void updateOrderStatus(Long orderId, String orderStatus);

}
