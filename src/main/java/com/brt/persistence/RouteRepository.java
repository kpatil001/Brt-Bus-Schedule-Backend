package com.brt.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brt.model.Route;


public interface RouteRepository extends JpaRepository<Route, Integer> {

	List<Route> findByStartStop(String from);

	List<Route> findByLastStop(String to);

	Route findByStartStopAndLastStop(String from, String to);

}
