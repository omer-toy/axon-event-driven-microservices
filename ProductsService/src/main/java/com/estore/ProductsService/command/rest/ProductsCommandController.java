package com.estore.ProductsService.command.rest;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estore.ProductsService.command.CreateProductCommand;
import com.estore.ProductsService.command.rest.model.CreateProduct;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {

	@Autowired
	CommandGateway commandGateway;

	@PostMapping(value = "/create")
	public String createProduct(@RequestBody CreateProduct product) {
		CreateProductCommand createProductCommand = CreateProductCommand.builder().price(product.getPrice())
				.quantity(product.getQuantity()).title(product.getTitle()).productId(UUID.randomUUID().toString())
				.build();
		String result = "";
		try {
			result = commandGateway.sendAndWait(createProductCommand);
		} catch (Exception e) {
			result = e.getLocalizedMessage();
		}
		return result;
	}
	

}
