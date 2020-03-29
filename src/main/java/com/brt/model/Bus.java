package com.brt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BUS_ID")
	private int busId;
	
	@Column(name = "BUS_NAME")
	private String busName;
	
	@ManyToOne
	@JoinColumn(name="ROUTE_ID")
	private Route route;
	
	@Column(name="START_TIME")
	private String startTime; 
	
	@Column(name="END_TIME")
	private String endTime;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "\nBus { \nbusId=" + busId + ", \nbusName=" + busName + ", \nroute=" + route + ", \nstartTime=" + startTime
				+ ", \nendTime=" + endTime + "} ";
	}
	
	
	
	
	
}
