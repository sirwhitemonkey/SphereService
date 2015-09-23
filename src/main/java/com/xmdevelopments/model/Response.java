package com.xmdevelopments.model;

import java.io.Serializable;

/**
 * Response
 */
@SuppressWarnings("serial")
public class Response implements Serializable {

	private int responseCode;

	private Object data;

	public Response(Object data, int responseCode) {
		this.data = data;
		this.responseCode = responseCode;
	}

	public Response() {
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
