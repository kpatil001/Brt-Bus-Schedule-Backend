package com.brt.domain;

public class ResponseMessage {
	
	private int status;
	
	private String message;
	
	private String apiVersion = "1";
	
	public ResponseMessage() {}

	public ResponseMessage(int status, String message, String apiVersion) {
		this.status = status;
		this.message = message;
		this.apiVersion=apiVersion;
	}
	
	public ResponseMessage(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
