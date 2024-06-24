package com.BillyFeng.ShoppingReceipt.Services;

import java.math.BigDecimal;

public interface CheckTaxRateService {

  public BigDecimal getSubTaxRate(String location, String name);
}
