package com.billyfeng.shoppingreceipt.entity;

import java.util.List;
import com.billyfeng.shoppingreceipt.vo.PrintShoppingReceiptVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GetTaxReq {

  @NotEmpty(message = "List cannot be empty")
  @Valid
  private List<PrintShoppingReceiptVo> list;

}
