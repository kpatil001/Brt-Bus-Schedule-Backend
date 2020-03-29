package com.brt.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brt.model.Stops;
import com.brt.model.StopsClassId;


@Repository
public interface StopsRepository extends JpaRepository<Stops, StopsClassId> {
	
	List<Stops> findByStopsClassId_RouteId(int id);

	List<Stops> findByStopsClassId_RouteIdAndBus_BusIdOrderByStopsClassId_Time(int routeId, int busId);

	List<Stops> findByStation_StationName(String to);

	List<Stops> findByStopsClassId_RouteIdAndBus_BusIdAndStopsClassId_TimeLessThan(int routeId, int busId, String time);

	@Query("select s from Stops s where s.stopsClassId.routeId=?1 and s.bus.busId=?2 and s.stopsClassId.time <= ?3")
	List<Stops> findStopsByRouteIdAndBusIdAndTimeLessThanEqualTo(int routeId, int busId, String time);

	@Query("select s from Stops s where s.stopsClassId.routeId=?1 and s.bus.busId=?2 and s.stopsClassId.time >= ?3")
	List<Stops> findStopsByRouteIdAndBusIdAndTimeGreaterThanEqualTo(int routeId, int busId, String time);

	List<Stops> findByStopsClassId_RouteIdAndBus_BusIdAndStopsClassId_TimeBetween(int routeId, int busId, String time,
			String time2);
	
}
