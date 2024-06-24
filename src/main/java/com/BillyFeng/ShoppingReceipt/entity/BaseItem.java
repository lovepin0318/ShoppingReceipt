package com.BillyFeng.ShoppingReceipt.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseItem {

  private String name;

  private BigDecimal price;

  private Integer quantity;

  private BigDecimal tax;

}
