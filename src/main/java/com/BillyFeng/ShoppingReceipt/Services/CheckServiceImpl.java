package com.billyfeng.shoppingreceipt.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.billyfeng.shoppingreceipt.entity.BaseItem;
import com.billyfeng.shoppingreceipt.entity.BaseResponse;
import com.billyfeng.shoppingreceipt.entity.GetTaxReq;
import com.billyfeng.shoppingreceipt.entity.GetTaxResp;
import com.billyfeng.shoppingreceipt.vo.PrintShoppingReceiptVo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CheckServiceImpl implements CheckService {

  @Autowired
  private CheckTaxRateService checkTaxRateService;

  @Override
  public BaseResponse<GetTaxResp> getTaxRate(GetTaxReq req) {
    BaseResponse<GetTaxResp> resp = new BaseResponse<>();
    GetTaxResp data = new GetTaxResp();
    List<BaseItem> respList = new ArrayList<>();

    try {
      BigDecimal subtotal = BigDecimal.ZERO;
      BigDecimal totalTax = BigDecimal.ZERO;

      for (PrintShoppingReceiptVo obj : req.getList()) {
        BaseItem baseItem = new BaseItem();
        BeanUtils.copyProperties(obj, baseItem);

        BigDecimal subtaxrate = checkTaxRateService.getSubTaxRate(obj.getLocation(), obj.getName());
        baseItem.setTax(calculateTax(obj.getPrice(), obj.getQuantity(), subtaxrate));

        respList.add(baseItem);
        subtotal = subtotal.add(obj.getPrice().multiply(new BigDecimal(obj.getQuantity()))
            .setScale(2, RoundingMode.UP));
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
