package com.billyfeng.shoppingreceipt.services;

import com.billyfeng.shoppingreceipt.entity.BaseResponse;
import com.billyfeng.shoppingreceipt.entity.GetTaxReq;
import com.billyfeng.shoppingreceipt.entity.GetTaxResp;


public interface CheckService {

  BaseResponse<GetTaxResp> getTaxRate(GetTaxReq req);

}
