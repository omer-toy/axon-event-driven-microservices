package com.estore.ProductsService.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estore.ProductsService.core.data.ProductEntity;
import com.estore.ProductsService.core.data.ProductsRepository;
import com.estore.ProductsService.core.events.ProductCreatedEvent;

@Component
@ProcessingGroup("product-group")
public class ProductEventHandler {

	@Autowired
	ProductsRepository productsRepository;

	@EventHandler
	public void on(ProductCreatedEvent event) {
		ProductEntity productEntity = new ProductEntity();

		BeanUtils.copyProperties(event, productEntity);

		productsRepository.save(productEntity);
	}
}
