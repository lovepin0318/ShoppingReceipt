package com.BillyFeng.ShoppingReceipt.Services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BillyFeng.ShoppingReceipt.Vo.PrintShoppingReceiptVo;

@Service
public class PrintShoppingReceiptService {

	@Autowired
	private CheckTaxRateService checkTaxRateService;

	public String printShoppingReceipt(List<PrintShoppingReceiptVo> printShoppingReceiptVoList) {

		if (null == printShoppingReceiptVoList || printShoppingReceiptVoList.isEmpty()) {
			return "Invalid input: Is null";
		}

		BigDecimal subtotal = BigDecimal.ZERO;
		BigDecimal totalTax = BigDecimal.ZERO;
		StringBuilder receipt = new StringBuilder();

		for (PrintShoppingReceiptVo printShoppingReceiptVo : printShoppingReceiptVoList) {
			BigDecimal price = printShoppingReceiptVo.getPrice();
			Integer quantity = printShoppingReceiptVo.getQuantity();
			String location = printShoppingReceiptVo.getLocation();
			String name = printShoppingReceiptVo.getName();

			BigDecimal totalcount = price.multiply(new BigDecimal(quantity));
			subtotal = subtotal.add(totalcount);

			BigDecimal taxRate = checkTaxRateService.getTaxRate(location, name);
			BigDecimal tax = calculateTax(price, quantity, taxRate);
			totalTax = totalTax.add(tax);

			receipt.append("Item Name: " + name + " , Quantity: " + quantity + " , Price: " + price + " , Sub Total Count: "
					+ totalcount + " \n");
		}

		BigDecimal total = subtotal.add(totalTax);

		receipt.append("Subtotal: ").append(subtotal).append("\n");
		receipt.append("Sales Tax: ").append(totalTax).append("\n");
		receipt.append("Total: ").append(total).append("\n");

		return receipt.toString();
	}

	private BigDecimal calculateTax(BigDecimal price, int quantity, BigDecimal taxRate) {
		BigDecimal tax = price.multiply(new BigDecimal(quantity)).multiply(taxRate);
		return tax.setScale(2, RoundingMode.UP);
	}

}