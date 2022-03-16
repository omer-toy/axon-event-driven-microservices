package com.estore.ProductsService;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.estore.ProductsService.command.interceptors.CreateProductCommandInterceptor;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductsServiceApplication {

	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	CommandBus commandBus;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceApplication.class, args);
	}
	
	@Autowired
	public void registerCreateProductCommandInterceptor() {
//		CommandBus commandBus = SimpleCommandBus.builder().build();
		commandBus.registerDispatchInterceptor(applicationContext.getBean(CreateProductCommandInterceptor.class));
//		return commandBus;
	}

}
