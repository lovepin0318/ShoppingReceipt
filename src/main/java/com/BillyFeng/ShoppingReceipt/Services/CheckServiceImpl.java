package com.BillyFeng.ShoppingReceipt.Services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.BillyFeng.ShoppingReceipt.Vo.PrintShoppingReceiptVo;
import com.BillyFeng.ShoppingReceipt.entity.BaseItem;
import com.BillyFeng.ShoppingReceipt.entity.BaseResponse;
import com.BillyFeng.ShoppingReceipt.entity.GetTaxReq;
import com.BillyFeng.ShoppingReceipt.entity.GetTaxResp;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CheckServiceImpl implements CheckService {

  @Autowired
	CheckTaxRateService checkTaxRateService;

	@Override
	public BaseResponse<GetTaxResp> getTaxRate(GetTaxReq req) {
		BaseResponse<GetTaxResp> resp = new BaseResponse<>();
		GetTaxResp data = new GetTaxResp();
		List<BaseItem> respList = new ArrayList<>();

		try {
			if (CollectionUtils.isEmpty(req.getList())) {
				resp.setCode(-1);
				resp.setMsg("Invalid input: Is null");
				return resp;
			}

			BigDecimal subtotal = BigDecimal.ZERO;
			BigDecimal totalTax = BigDecimal.ZERO;

			for (PrintShoppingReceiptVo obj : req.getList()) {
				BaseItem baseItem = new BaseItem();
				BeanUtils.copyProperties(obj, baseItem);
				
				BigDecimal subtaxrate = checkTaxRateService.getSubTaxRate(obj.getLocation(), obj.getName());
				baseItem.setTax(calculateTax(obj.getPrice(), obj.getQuantity(), subtaxrate));

				respList.add(baseItem);
				subtotal = subtotal.add(baseItem.getPrice());
				totalTax = totalTax.add(baseItem.getTax());
			}
			data.setList(respList);
			data.setSubtotal(subtotal);
			data.setTax(totalTax);
			data.setTotal(subtotal.add(totalTax));
			resp.setData(data);

		} catch (Exception e) {
			log.error("getTaxRate error {}", e.getMessage(), e);
		}
		return resp;
	}

	private BigDecimal calculateTax(BigDecimal price, int quantity, BigDecimal taxRate) {
		BigDecimal tax = price.multiply(new BigDecimal(quantity)).multiply(taxRate);
		return tax.setScale(2, RoundingMode.UP);
	}

}
