package com.brt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StopsClassId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="ROUTE_ID")
	private int routeId;
	
	@Column(name="TIME")
	private String time;
	
	public StopsClassId() {
		super();
	}

	public StopsClassId(int routeId, String time) {
		super();
		this.routeId = routeId;
		this.time = time;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "\nStopsClassId { \nrouteId=" + routeId + ", \ntime=" + time + "} ";
	}


//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + routeId;
//		result = prime * result + ((time == null) ? 0 : time.hashCode());
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		StopsId other = (StopsId) obj;
//		if (routeId != other.routeId)
//			return false;
//		if (time == null) {
//			if (other.time != null)
//				return false;
//		} else if (!time.equals(other.time))
//			return false;
//		return true;
//	}
//	
//	

}
