package com.billyfeng.shoppingreceipt.entity;

import java.util.List;
import com.billyfeng.shoppingreceipt.vo.PrintShoppingReceiptVo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GetTaxReq {

  @NotBlank(message = "Invalid input: Is null")
  private List<PrintShoppingReceiptVo> list;

}
