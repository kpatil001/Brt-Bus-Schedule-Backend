package com.brt.domain;

public class BrtOutputList {
	private String stationName,time;

	
	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "\nBrtOutputList { \nstationName=" + stationName + ", \ntime=" + time + "} ";
	}
	
	

}
