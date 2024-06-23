package com.BillyFeng.ShoppingReceipt.entity;

import java.util.List;

import com.BillyFeng.ShoppingReceipt.Vo.PrintShoppingReceiptVo;

import lombok.Data;

@Data
public class GetTaxReq {

	private List<PrintShoppingReceiptVo> list;

}
