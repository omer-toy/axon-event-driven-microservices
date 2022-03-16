package com.estore.OrdersService.core.events;

import com.estore.OrdersService.command.OrderStatus;
import lombok.Data;

@Data
public class OrderCreatedEvent {
	
	private String orderId;
	private String userId;
	private String productId;
	private int quantity;
	private String addressId;
	private OrderStatus orderStatus;
}
