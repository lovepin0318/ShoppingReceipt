package com.billyfeng.shoppingreceipt.vo;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrintShoppingReceiptVo {

  @NotBlank(message = "Invalid input: Parameter Name Is null")
  private String name;

  @NotBlank(message = "Invalid input: Parameter Price Is null")
  private BigDecimal price;

  @NotBlank(message = "Invalid input: Parameter Quantity Is null")
  private int quantity;

  @NotBlank(message = "Invalid input: Parameter Location Is null")
  private String location;
}
