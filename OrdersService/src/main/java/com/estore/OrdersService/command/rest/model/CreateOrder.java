package com.estore.OrdersService.command.rest.model;

import lombok.Data;

@Data
public class CreateOrder {

	private String productId;
	private Integer quantity;
	private String addressId;
}
