package com.BillyFeng.ShoppingReceipt.Vo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PrintShoppingReceiptVo {

	private String name;
	private BigDecimal price;
	private int quantity;
	private String location;
}