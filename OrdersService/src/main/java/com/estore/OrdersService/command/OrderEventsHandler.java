package com.estore.OrdersService.command;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estore.OrdersService.core.data.OrderEntity;
import com.estore.OrdersService.core.data.OrdersRepository;
import com.estore.OrdersService.core.events.OrderCreatedEvent;

@Component
@ProcessingGroup("order-group")
public class OrderEventsHandler {
	
	@Autowired
	OrdersRepository ordersRepository;

	@EventHandler
	public void on(OrderCreatedEvent orderCreatedEvent) {
		OrderEntity orderEntity = new OrderEntity();

		BeanUtils.copyProperties(orderCreatedEvent, orderEntity);

		ordersRepository.save(orderEntity);
	}
}
