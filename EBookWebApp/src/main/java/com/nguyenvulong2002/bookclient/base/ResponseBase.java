package com.nguyenvulong2002.bookclient.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ResponseBase {

	@JsonProperty("responseCode")
	private String responseCode;
	
	@JsonProperty("responseMessage")
	private String responseMessage;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
