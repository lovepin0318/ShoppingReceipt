package com.BillyFeng.ShoppingReceipt.entity;

import lombok.Data;

@Data
public class BaseResponse<T> {

	Integer code = 0;

	String msg = "success";

	T data;

<<<<<<< HEAD
	public BaseResponse(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public BaseResponse() {
	}
=======
    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public BaseResponse() {}
>>>>>>> cd13b59 (try catch 調整)

}
