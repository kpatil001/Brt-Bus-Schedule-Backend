package com.brt.service;

import java.util.List;
import java.util.Optional;

import com.brt.domain.BrtListWithBus;
import com.brt.domain.FromTo;
import com.brt.exception.ServicesException;
import com.brt.model.Bus;
import com.brt.model.LoginDtls;
import com.brt.model.Route;
import com.brt.model.Stops;
import com.brt.model.UserDtls;

public interface BrtService {

	void addRecordService(UserDtls userDtls) throws ServicesException;

	Optional<UserDtls> getRecordService(int id);

	void checkLoginService(LoginDtls loginDtls) throws ServicesException;

	Optional<Route> getRouteService(int id);

	List<Stops> getStopService(int id);

	List<BrtListWithBus> fetchTimeTableService(FromTo fromTo) throws ServicesException;
	
	public List<Bus> tryFunc(int a);

}
