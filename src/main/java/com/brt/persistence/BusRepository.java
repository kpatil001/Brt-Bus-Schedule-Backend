package com.brt.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brt.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

	List<Bus> findByRoute_RouteId(int routeId);

}
