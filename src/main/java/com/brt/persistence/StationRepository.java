package com.brt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brt.model.Station;


@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

	Station findByStationName(String upperCase);

}
