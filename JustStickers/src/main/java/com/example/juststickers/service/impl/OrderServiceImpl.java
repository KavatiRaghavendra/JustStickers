package com.example.juststickers.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.example.juststickers.Repo.OrderRepo;
import com.example.juststickers.Repo.ProductRepo;
import com.example.juststickers.constants.ApplicationConstants;
import com.example.juststickers.dto.OrderItemReponseDto;
import com.example.juststickers.dto.OrderRequestDto;
import com.example.juststickers.dto.OrderResponseDto;
import com.example.juststickers.entity.Customer;
import com.example.juststickers.entity.Order;
import com.example.juststickers.entity.OrderItem;
import com.example.juststickers.entity.Product;
import com.example.juststickers.exception.ResourceNotFoundException;
import com.example.juststickers.service.IOrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl  implements IOrderService{

	 private final OrderRepo orderRepo;
	 private final ProductRepo productRepository;
	 private final ProfileServiceImpl profileService;

	@Override
	public void createOrder(OrderRequestDto orderRequest) {
		Customer customer = profileService.getAuthenticatedCustomer();
        // Create Order
        Order order = new Order();
        order.setCustomer(customer);
        BeanUtils.copyProperties(orderRequest, order);
        order.setOrderStatus(ApplicationConstants.ORDER_STATUS_CREATED);
        // Map OrderItems
        List<OrderItem> orderItems = orderRequest.items().stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "ProductID",
                            item.productId().toString()));
            orderItem.setProduct(product);
            orderItem.setQuantity(item.quantity());
            orderItem.setPrice(item.price());
            return orderItem;
        }).collect(Collectors.toList());
        order.setOrderItems(orderItems);
        orderRepo.save(order);	
	}

	@Override
	public List<OrderResponseDto> getCustomerOrders() {
		Customer customer = profileService.getAuthenticatedCustomer();
		 List<Order> orders = orderRepo.findOrdersByCustomerWithNativeQuery(customer.getCustomerId());
		  return orders.stream().map(this::mapToOrderResponseDTO).collect(Collectors.toList());

	}
	 private OrderResponseDto mapToOrderResponseDTO(Order order) {
	        // Map Order Items
	        List<OrderItemReponseDto> itemDTOs = order.getOrderItems().stream()
	                .map(this::mapToOrderItemResponseDTO)
	                .collect(Collectors.toList());
	        OrderResponseDto orderResponseDto = new OrderResponseDto(order.getOrderId()
	                , order.getOrderStatus(), order.getTotalPrice(), order.getCreatedAt().toString()
	                , itemDTOs);
	        return orderResponseDto;
	    }

	    /**
	     * Map OrderItem entity to OrderItemResponseDto
	     */
	    private OrderItemReponseDto mapToOrderItemResponseDTO(OrderItem orderItem) {
	        OrderItemReponseDto itemDTO = new OrderItemReponseDto(
	                orderItem.getProduct().getName(), orderItem.getQuantity(),
	                orderItem.getPrice(), orderItem.getProduct().getImageUrl());
	        return itemDTO;
	    }

	    
		@Override
		public List<OrderResponseDto> getAllPendingOrders() {
				List<Order> orders = orderRepo.findOrdersByStatusWithNativeQuery(ApplicationConstants.ORDER_STATUS_CREATED);
		         
				return orders.stream().map(this::mapToOrderResponseDTO).collect(Collectors.toList());
		}

		@Override
		public void updateOrderStatus(Long orderId, String orderStatus) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String email = authentication.getName();
	        orderRepo.updateOrderStatus(orderId,orderStatus,email);
	   	}
	
		

	

}
