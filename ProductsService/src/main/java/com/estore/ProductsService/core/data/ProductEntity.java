package com.estore.ProductsService.core.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "products")
@Entity
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = 4264704092255171501L;

	@Id
	@Column(name = "ID")
	private String productId;
	@Column(unique = true)
	private String title;
	private BigDecimal price;
	private Integer quantity;
}
