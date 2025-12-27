package com.example.juststickers.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.juststickers.entity.Order;

public interface OrderRepo  extends JpaRepository<Order,Long>{

	 @Query(value = "SELECT * FROM orders o WHERE o.customer_id=:customerId ORDER BY o.created_at DESC"
			  , nativeQuery = true)
	 List<Order> findOrdersByCustomerWithNativeQuery(@Param("customerId") Long customerId);

	 @Query(value = "SELECT * FROM orders o WHERE o.order_status=?1", nativeQuery = true)
	  List<Order> findOrdersByStatusWithNativeQuery(String orderStatus);
	
	 @Transactional
	  @Modifying
	  @Query("UPDATE Order o SET o.orderStatus=:orderStatus,o.updatedAt=CURRENT_TIMESTAMP,o.updatedBy=:email WHERE o.orderId=:orderId")
	int updateOrderStatus(@Param("orderId")Long orderId,@Param("orderStatus") String orderStatus,@Param("email") String email);


}
