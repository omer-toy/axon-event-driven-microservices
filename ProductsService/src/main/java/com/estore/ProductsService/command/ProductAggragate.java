package com.estore.ProductsService.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.estore.ProductsService.command.rest.model.CreateProduct;
import com.estore.ProductsService.core.events.ProductCreatedEvent;

@Aggregate
public class ProductAggragate {

	@AggregateIdentifier
	private String productId;
	private CreateProduct product;

	public ProductAggragate() {
	}

	@CommandHandler
	public ProductAggragate(CreateProductCommand createProductCommand) {
		this.product = new CreateProduct();
//		validate command

//		validate command end

		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

		BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

		AggregateLifecycle.apply(productCreatedEvent);
	}

	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		this.productId = productCreatedEvent.getProductId();
		BeanUtils.copyProperties(productCreatedEvent, this.product);
	}
}
