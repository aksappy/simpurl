package org.simpurl.utils;

public class CustomResponse {

	private Integer responseCode;
	private String responseText;

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	@Override
	public String toString() {
		return "CustomResponse [responseCode=" + responseCode + ", responseText=" + responseText + "]";
	}

}
