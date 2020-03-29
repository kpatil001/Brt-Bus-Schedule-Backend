package com.brt.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrtWrapper {

	private ResponseMessage responseMessage;
	
	@JsonProperty("response")
	private List<BrtListWithBus> response;
	
	
	public BrtWrapper() {
		super();
	}
	
	public BrtWrapper(ResponseMessage responseMessage,List<BrtListWithBus> output) {
		super();
		this.responseMessage = responseMessage;
		this.response = output;
	}
	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public List<BrtListWithBus> getResponse() {
		return response;
	}

	public void setResponse(List<BrtListWithBus> response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "BrtWrapper [responseMessage=" + responseMessage + ", response=" +response + "]";
	}
	
}
