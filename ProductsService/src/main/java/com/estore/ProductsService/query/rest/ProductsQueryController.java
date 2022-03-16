package com.estore.ProductsService.query.rest;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estore.ProductsService.query.FindProductsQuery;
import com.estore.ProductsService.query.rest.model.Product;


@RestController
@RequestMapping("/products")
public class ProductsQueryController {

	@Autowired
	QueryGateway queryGateway;

	@GetMapping(value = "/get")
	public List<Product> getProducts() {
		FindProductsQuery findProductsQuery = new FindProductsQuery();
		return queryGateway.query(findProductsQuery, ResponseTypes.multipleInstancesOf(Product.class)).join();
	}

//	@GetMapping(value = "/get/{productId}")
//	public List getProduct(@PathVariable("productId") String productId) {
//		return "my product";
//	}
}
