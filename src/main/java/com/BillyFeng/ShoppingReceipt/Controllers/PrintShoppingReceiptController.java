package com.billyfeng.shoppingreceipt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.billyfeng.shoppingreceipt.entity.BaseResponse;
import com.billyfeng.shoppingreceipt.entity.GetTaxReq;
import com.billyfeng.shoppingreceipt.entity.GetTaxResp;
import com.billyfeng.shoppingreceipt.services.CheckService;

@RestController
public class PrintShoppingReceiptController {

  @Autowired
  private CheckService checkService;

  @PostMapping("/getshoppingreceipt")
  public BaseResponse<GetTaxResp> printShoppingReceipt(@Validated @RequestBody GetTaxReq req) {
    return checkService.getTaxRate(req);
  }
}
