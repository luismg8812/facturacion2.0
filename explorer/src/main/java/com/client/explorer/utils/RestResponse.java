package com.client.explorer.utils;

import java.io.Serializable;

public class RestResponse implements Serializable{

	
	private static final long serialVersionUID = -2845341443742994655L;
	private Integer responseCode;
	private String message;
	
	public RestResponse(Integer responseCode) {
		super();
		this.responseCode =responseCode;
	}
	
	public RestResponse(Integer responseCode,String message) {
		this.responseCode =responseCode;
		this.message =message;
	}
	
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
