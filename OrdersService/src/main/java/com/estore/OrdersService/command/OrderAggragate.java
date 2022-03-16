package com.estore.OrdersService.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.estore.OrdersService.command.rest.model.CreateOrder;
import com.estore.OrdersService.core.events.OrderCreatedEvent;

@Aggregate
public class OrderAggragate {

	@AggregateIdentifier
	private String orderId;
	private CreateOrder order;

	public OrderAggragate() {
	}

	@CommandHandler
	public OrderAggragate(CreateOrderCommand createOrderCommand) {
		this.order = new CreateOrder();

		OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();

		BeanUtils.copyProperties(createOrderCommand, orderCreatedEvent);

		AggregateLifecycle.apply(orderCreatedEvent);
	}

	@EventSourcingHandler
	public void on(OrderCreatedEvent orderCreatedEvent) {
		this.orderId = orderCreatedEvent.getProductId();
		BeanUtils.copyProperties(orderCreatedEvent, this.order);
	}
	
}
