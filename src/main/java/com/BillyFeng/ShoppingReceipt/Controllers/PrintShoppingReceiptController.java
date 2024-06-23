package com.BillyFeng.ShoppingReceipt.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BillyFeng.ShoppingReceipt.Services.CheckService;
import com.BillyFeng.ShoppingReceipt.entity.BaseResponse;
import com.BillyFeng.ShoppingReceipt.entity.GetTaxReq;
import com.BillyFeng.ShoppingReceipt.entity.GetTaxResp;

import jakarta.annotation.Resource;

@RestController
public class PrintShoppingReceiptController {

	@Resource
	CheckService checkService;

	@PostMapping("/getshoppingreceipt")
	public BaseResponse<GetTaxResp> printShoppingReceipt(@RequestBody GetTaxReq req) {
		return checkService.getTaxRate(req);
	}
}
