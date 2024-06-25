package com.billyfeng.shoppingreceipt.controllers;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.billyfeng.shoppingreceipt.entity.BaseResponse;
import com.billyfeng.shoppingreceipt.entity.GetTaxReq;
import com.billyfeng.shoppingreceipt.entity.GetTaxResp;
import com.billyfeng.shoppingreceipt.services.CheckService;
import jakarta.validation.Valid;

@RestController
public class PrintShoppingReceiptController {

  @Autowired
  private CheckService checkService;

  @PostMapping("/getshoppingreceipt")
  public ResponseEntity<BaseResponse<GetTaxResp>> printShoppingReceipt(
      @Valid @RequestBody GetTaxReq req, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      String errors = bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage)
          .collect(Collectors.joining(", "));
      BaseResponse<GetTaxResp> errorResponse =
          new BaseResponse<>(-1, "Validation failed: " + errors);
      return ResponseEntity.badRequest().body(errorResponse);
    }
    BaseResponse<GetTaxResp> response = checkService.getTaxRate(req);
    return ResponseEntity.ok(response);
  }
}
