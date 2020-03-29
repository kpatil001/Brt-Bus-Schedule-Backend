package com.brt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Station")
public class Station {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STATION_ID")
	private int stationId;
	
	@Column(name="STATION_NAME")
	private String stationName;

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		return "\nStation { \nstationId=" + stationId + ", \nstationName=" + stationName + "} ";
	}
	
	
}
