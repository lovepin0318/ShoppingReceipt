package com.BillyFeng.ShoppingReceipt.entity;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class GetTaxResp {

	private List<BaseItem> list;

	private BigDecimal subtotal;

	private BigDecimal tax;

	private BigDecimal total;

}
