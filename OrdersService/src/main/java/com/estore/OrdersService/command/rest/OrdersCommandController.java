package com.estore.OrdersService.command.rest;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estore.OrdersService.command.CreateOrderCommand;
import com.estore.OrdersService.command.rest.model.CreateOrder;

@RestController
@RequestMapping("/orders")
public class OrdersCommandController {

	@Autowired
	CommandGateway commandGateway;

	@PostMapping(value = "/create")
	public String createOrder(@RequestBody CreateOrder order) {
		CreateOrderCommand createOrderCommand = CreateOrderCommand.builder().productId(order.getProductId())
				.quantity(order.getQuantity()).addressId(order.getAddressId()).orderId(UUID.randomUUID().toString())
				.userId("27b95829-4f3f-4ddf-8983-151ba010e35b").build();
		String result = "";
		try {
			result = commandGateway.sendAndWait(createOrderCommand);
		} catch (Exception e) {
			result = e.getLocalizedMessage();
		}
		return result;
	}
}
