package com.BillyFeng.ShoppingReceipt.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BillyFeng.ShoppingReceipt.Services.PrintShoppingReceiptService;
import com.BillyFeng.ShoppingReceipt.Vo.PrintShoppingReceiptVo;

@RestController
public class PrintShoppingReceiptController {

	@Autowired
	PrintShoppingReceiptService printShoppingReceiptService;

	@PostMapping("/getshoppingreceipt")
	public String printShoppingReceipt(@RequestBody List<PrintShoppingReceiptVo> printShoppingReceiptVoList) {
		return printShoppingReceiptService.printShoppingReceipt(printShoppingReceiptVoList);
	}
}
