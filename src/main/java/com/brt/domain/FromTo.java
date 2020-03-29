package com.brt.domain;

public class FromTo {
	
	String from;
	String to;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	@Override
	public String toString() {
		return "FromTo [from=" + from + ", to=" + to + "]";
	}
	

}
