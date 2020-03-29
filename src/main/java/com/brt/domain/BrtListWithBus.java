package com.brt.domain;

import java.util.List;

public class BrtListWithBus {
	
	private String busName;
	private List<BrtOutputList> timeTable;
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public List<BrtOutputList> getTimeTable() {
		return timeTable;
	}
	public void setTimeTable(List<BrtOutputList> timeTable) {
		this.timeTable = timeTable;
	}
	@Override
	public String toString() {
		return "BrtListWithBus [busName=" + busName + ", timeTable=" + timeTable + "]";
	}
	
	

}
