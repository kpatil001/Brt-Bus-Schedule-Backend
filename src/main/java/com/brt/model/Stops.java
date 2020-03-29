package com.brt.model;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stops")
public class Stops {
	
	@ManyToOne
	@JoinColumn(name="STATION_ID")
	private Station station;
	
//	@Column(name="STOP_ID")
	private int stopId;
	
	@ManyToOne
	@JoinColumn(name="BUS_ID")
	private Bus bus;
	
	@EmbeddedId
	private StopsClassId stopsClassId;

	public StopsClassId getStopsClassId() {
		return stopsClassId;
	}

	
	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}


	public void setStopsClassId(StopsClassId stopsClassId) {
		this.stopsClassId = stopsClassId;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	@Override
	public String toString() {
		return "\nStops : { \nstation=" + station + ", \nstopId=" + stopId + ", \nbusId=" + bus + ", \nstopsClassId="
				+ stopsClassId + " } ";
	}

	



	
	
	
	
}
