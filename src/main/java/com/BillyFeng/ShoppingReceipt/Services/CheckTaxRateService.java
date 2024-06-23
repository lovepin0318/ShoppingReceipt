package com.BillyFeng.ShoppingReceipt.Services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CheckTaxRateService {

	private static final BigDecimal CA_TAX_RATE = new BigDecimal("0.0975");
	private static final BigDecimal NY_TAX_RATE = new BigDecimal("0.08875");

	public BigDecimal getTaxRate(String location, String name) {
		BigDecimal taxRate = BigDecimal.ZERO;
		switch (location.toUpperCase()) {
		case "CA":
			taxRate = CA_TAX_RATE;
			break;
		case "NY":
			taxRate = NY_TAX_RATE;
			break;
		default:
			break;
		}
		// Exemptions
		if ((location.equalsIgnoreCase("CA") && isFood(name))
				|| (location.equalsIgnoreCase("NY") && (isFood(name) || isClothing(name)))) {
			taxRate = BigDecimal.ZERO;
		}
		return taxRate;
	}

	private boolean isFood(String name) {
		return name.toLowerCase().contains("food");
	}

	private boolean isClothing(String name) {
		return name.toLowerCase().contains("clothing");
	}
}
