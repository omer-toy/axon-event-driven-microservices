package com.estore.ProductsService.command;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estore.ProductsService.core.data.ProductLookupEntity;
import com.estore.ProductsService.core.data.ProductLookupRepository;
import com.estore.ProductsService.core.events.ProductCreatedEvent;

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventsHandler {

	@Autowired
	ProductLookupRepository productLookupRepository;

	@EventHandler
	public void on(ProductCreatedEvent event) {
		ProductLookupEntity productLookupEntity = new ProductLookupEntity();
		productLookupEntity.setProductId(event.getProductId());
		productLookupEntity.setTitle(event.getTitle());

		productLookupRepository.save(productLookupEntity);

	}

}
