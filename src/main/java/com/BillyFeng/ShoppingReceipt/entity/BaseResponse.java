package com.BillyFeng.ShoppingReceipt.entity;

import lombok.Data;

@Data
public class BaseResponse<T> {

	Integer code = 0;

	String msg = "success";

	T data;

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public BaseResponse() {}

}
