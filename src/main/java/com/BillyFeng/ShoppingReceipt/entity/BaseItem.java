package com.BillyFeng.ShoppingReceipt.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BaseItem {

	private String name;

	private BigDecimal price;

	private Integer quantity;

	private BigDecimal tax;

}
