package com.BillyFeng.ShoppingReceipt.Services;

import com.BillyFeng.ShoppingReceipt.entity.BaseResponse;
import com.BillyFeng.ShoppingReceipt.entity.GetTaxReq;
import com.BillyFeng.ShoppingReceipt.entity.GetTaxResp;


public interface CheckService {

  BaseResponse<GetTaxResp> getTaxRate(GetTaxReq req);

}
