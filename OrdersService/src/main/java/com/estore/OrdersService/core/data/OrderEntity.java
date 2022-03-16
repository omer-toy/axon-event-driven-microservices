package com.estore.OrdersService.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.estore.OrdersService.command.OrderStatus;

import lombok.Data;

@Data
@Table(name = "orders")
@Entity
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 5624403880438192522L;
	@Id
	@Column(unique = true)
	public String orderId;
	private String productId;
	private String userId;
	private int quantity;
	private String addressId;
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
}
