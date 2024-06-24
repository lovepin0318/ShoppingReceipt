package com.BillyFeng.ShoppingReceipt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

  Integer code = 0;

  String msg = "success";

  T data;

  public BaseResponse(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

}
