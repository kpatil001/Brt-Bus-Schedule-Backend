package com.brt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Route")
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROUTE_ID")
	private int routeId;
	
	@Column(name="START_STOP")
	private String startStop;
	
	@Column(name="LAST_STOP")
	private String lastStop;
	
//	@Column(name="BUS_ID")
//	private String  busId;
//	
//	@Column(name="START_TIME")
//	private String startTime; 
//	
//	@Column(name="END_TIME")
//	private String endTime;
	
	
	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	public String getStartStop() {
		return startStop;
	}

	public void setStartStop(String startStop) {
		this.startStop = startStop;
	}

	public String getLastStop() {
		return lastStop;
	}

	public void setLastStop(String lastStop) {
		this.lastStop = lastStop;
	}
	
//	public String getBusId() {
//	return busId;
//}
//
//public void setBusId(String busId) {
//	this.busId = busId;
//}

	
//	public String getStartTime() {
//		return startTime;
//	}
//
//	public void setStartTime(String startTime) {
//		this.startTime = startTime;
//	}
//
//	public String getEndTime() {
//		return endTime;
//	}
//
//	public void setEndTime(String endTime) {
//		this.endTime = endTime;
//	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + "startStop=" + startStop + ", lastStop=" + lastStop;
	}
	
	
}
