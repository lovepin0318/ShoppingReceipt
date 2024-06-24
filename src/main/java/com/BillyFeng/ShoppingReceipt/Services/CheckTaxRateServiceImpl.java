package com.BillyFeng.ShoppingReceipt.Services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class CheckTaxRateServiceImpl implements CheckTaxRateService {
  private static final BigDecimal CA_TAX_RATE = new BigDecimal("0.0975");

  private static final BigDecimal NY_TAX_RATE = new BigDecimal("0.08875");

  @Override
  public BigDecimal getSubTaxRate(String location, String name) {
    BigDecimal taxRate = BigDecimal.ZERO;

    switch (location.toUpperCase()) {
      case "CA" -> taxRate = isExempt(location, name) ? BigDecimal.ZERO : CA_TAX_RATE;
      case "NY" -> taxRate = isExempt(location, name) ? BigDecimal.ZERO : NY_TAX_RATE;
      default -> taxRate = BigDecimal.ZERO;
    }

    return taxRate;
  }

  private boolean isExempt(String location, String name) {
    String lowerName = name.toLowerCase();
    if (("CA".equalsIgnoreCase(location) && lowerName.contains("food"))
        || ("NY".equalsIgnoreCase(location)
            && (lowerName.contains("food") || lowerName.contains("clothing")))) {
      return true;
    }
    return false;
  }
}
