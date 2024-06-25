package com.billyfeng.shoppingreceipt.vo;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Component
public class PrintShoppingReceiptVo {

  @NotBlank(message = "Invalid input: Parameter Name Is null")
  private String name;

  @NotNull(message = "Invalid input: Parameter Price Is null")
  @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
  private BigDecimal price;

  @NotNull(message = "Invalid input: Parameter Quantity Is null")
  @Min(value = 1, message = "Quantity must be at least 1")
  private int quantity;

  @NotBlank(message = "Invalid input: Parameter Location Is null")
  private String location;
}
