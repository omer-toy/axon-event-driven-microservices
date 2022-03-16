package com.estore.ProductsService.query;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estore.ProductsService.core.data.ProductsRepository;
import com.estore.ProductsService.query.rest.model.Product;

@Component
public class ProductsQueryHandler {

	@Autowired
	ProductsRepository productsRepository;

	@QueryHandler
	List<Product> findProducts(FindProductsQuery query) {
		return productsRepository.findAll().parallelStream().map(storedProduct -> {
			Product product = new Product();
			BeanUtils.copyProperties(storedProduct, product);
			return product;
		}).collect(Collectors.toList());
	}
}
