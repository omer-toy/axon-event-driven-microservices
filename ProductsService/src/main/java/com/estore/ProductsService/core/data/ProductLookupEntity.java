package com.estore.ProductsService.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "productlookup")
public class ProductLookupEntity implements Serializable {

	private static final long serialVersionUID = -7185407652829922825L;
	
	@Id
	@Column(name = "ID")
	private String productId;
	@Column(unique = true)
	private String title;

}
