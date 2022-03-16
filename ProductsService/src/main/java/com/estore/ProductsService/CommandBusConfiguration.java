package com.estore.ProductsService;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.context.annotation.Configuration;

import com.estore.ProductsService.command.interceptors.CreateProductCommandInterceptor;

//@Configuration
public class CommandBusConfiguration {

	public CommandBus configureCommandBus() {
		CommandBus commandBus = SimpleCommandBus.builder().build();
		commandBus.registerDispatchInterceptor(new CreateProductCommandInterceptor());
		return commandBus;
	}
}
