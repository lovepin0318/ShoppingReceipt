package com.billyfeng.shoppingreceipt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

  private Integer code = 0;

  private String msg = "success";

  private T data;

  public BaseResponse(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

}
