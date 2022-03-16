package com.estore.ProductsService.command.rest.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateProduct {

	private String title;
	private BigDecimal price;
	private Integer quantity;

}
