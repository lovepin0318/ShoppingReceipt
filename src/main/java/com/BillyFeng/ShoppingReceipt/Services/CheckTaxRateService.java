package com.billyfeng.shoppingreceipt.services;

import java.math.BigDecimal;

public interface CheckTaxRateService {

  BigDecimal getSubTaxRate(String location, String name);
}
