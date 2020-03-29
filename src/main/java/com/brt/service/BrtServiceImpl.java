package com.brt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brt.domain.BrtListWithBus;
import com.brt.domain.BrtOutputList;
import com.brt.domain.FromTo;
import com.brt.exception.ServicesException;
import com.brt.model.Bus;
import com.brt.model.LoginDtls;
import com.brt.model.Route;
import com.brt.model.Station;
import com.brt.model.Stops;
import com.brt.model.UserDtls;
import com.brt.persistence.BusRepository;
import com.brt.persistence.LoginDtlsRepository;
import com.brt.persistence.RouteRepository;
import com.brt.persistence.StationRepository;
import com.brt.persistence.StopsRepository;
import com.brt.persistence.UserDtlsRepository2;



@Service
@Transactional(rollbackFor=Throwable.class)
public class BrtServiceImpl implements BrtService {

	@Autowired UserDtlsRepository2 userDtlsRepository2;
	@Autowired LoginDtlsRepository loginDtlsRepository;
	@Autowired RouteRepository routeRepository;
	@Autowired StopsRepository stopsRepository;
	@Autowired BusRepository busRepository;
	@Autowired StationRepository stationRepository;
	
	@Override
	public void addRecordService(UserDtls userDtls) throws ServicesException {
		
		LoginDtls loginDtls = loginDtlsRepository.findByEmail(userDtls.getLoginDtls().getEmail());
		
		checkRecord(userDtls);
		if(loginDtls != null)
		{
			throw new ServicesException("Email already exist");
		}
		 userDtlsRepository2.save(userDtls);
	}
	public void checkRecord(UserDtls userDtls) throws ServicesException
	{
		if(userDtls.getFirstName().isEmpty())
			throw new ServicesException("First Name cannot be Empty");
		else if (userDtls.getLastName().isEmpty())
			throw new ServicesException("Last Name cannot be Empty");
		else if(userDtls.getPhoneNo().isEmpty())
			throw new ServicesException("Phone Number cannot be Empty");
		else if(userDtls.getLoginDtls().getEmail().isEmpty())
			throw new ServicesException("Email cannot be Empty");
		else if(userDtls.getLoginDtls().getPwd().isEmpty())
			throw new ServicesException("Password cannot be Empty");
//		return true;
			
	}

	@Override
	public Optional<UserDtls> getRecordService(int id) {
		return userDtlsRepository2.findById(id);
	}
	
	public Optional<Route> getRouteService(int id) {
		return routeRepository.findById(id);
	}
	
	public List<Bus> tryFunc(int a)
	{
		List<Bus> multipleBus;
		multipleBus = busRepository.findByRoute_RouteId(a);
		
		return multipleBus;
		
	}
	
	

	@Override
	public void checkLoginService(LoginDtls loginDtls)throws ServicesException {
		LoginDtls test= loginDtlsRepository.findByEmail(loginDtls.getEmail());
		System.out.println("logindtls is::" + loginDtls);
		System.out.println("Test is:" + test);
		if(test!=null)
		{
			if(!((test.getPwd()).equals(loginDtls.getPwd())))
				throw new ServicesException("Invalid Password");
		}
		else 
			throw new ServicesException("Invalid Email");
		
		
	}

	@Override
	public List<Stops> getStopService(int id) {
	
		return stopsRepository.findByStopsClassId_RouteId(id);
	}

	@Override
	public List<BrtListWithBus> fetchTimeTableService(FromTo fromTo) throws ServicesException {
		List<BrtListWithBus> outObjList =new ArrayList<BrtListWithBus>();
		Route singleRoute = routeRepository.findByStartStopAndLastStop(fromTo.getFrom(),fromTo.getTo());
		List<Bus> multipleBus;
		
		
		Station fromIsValid = stationRepository.findByStationName(fromTo.getFrom().toUpperCase());
		Station toIsValid = stationRepository.findByStationName(fromTo.getTo().toUpperCase());
		
		
		if(fromIsValid == null)		//If source is not present in DB.
			{
				throw new ServicesException("Invalid Arrival Station Name");
			}
		else if(toIsValid == null)				//If destination is not present in DB.
		{
			throw new ServicesException("Invalid Destination");
		}
		else if((fromTo.getFrom()).equals(fromTo.getTo()))		//If source and destination both are same.
		{
			throw new ServicesException("Arrival and Destination cannot be same ");
		}
		
		//Use Case 1: 
		else if (singleRoute != null) {
			multipleBus = busRepository.findByRoute_RouteId(singleRoute.getRouteId());
			for (Bus b : multipleBus) {
				List<BrtOutputList> tempList = new ArrayList<BrtOutputList>();
				BrtListWithBus outObj = new BrtListWithBus();
				List<Stops> listOfStops = stopsRepository
						.findByStopsClassId_RouteIdAndBus_BusIdOrderByStopsClassId_Time(singleRoute.getRouteId(),b.getBusId());
				for (Stops a : listOfStops) {
					BrtOutputList temp = new BrtOutputList();
					temp.setStationName(a.getStation().getStationName());
					temp.setTime(a.getStopsClassId().getTime());
					tempList.add(temp);
				}

				outObj.setBusName(listOfStops.get(0).getBus().getBusName());
				outObj.setTimeTable(tempList);
				outObjList.add(outObj);
			}

		//return outObjList;

		}
		
		List<Route> fromInStartStop = routeRepository.findByStartStop(fromTo.getFrom());
		List<Route> toInLastStop = routeRepository.findByLastStop(fromTo.getTo());
		
		//Use Case 2:
		if((!fromInStartStop.isEmpty()) && toInLastStop.isEmpty())
		{
			List<Stops> toStopList = stopsRepository.findByStation_StationName(fromTo.getTo());
			for(Route a: fromInStartStop)
			{	
				multipleBus = busRepository.findByRoute_RouteId(a.getRouteId());
				Iterator<Bus> itr = multipleBus.iterator();
				
				for(Stops b: toStopList)
				{
					if(a.getRouteId()==b.getStopsClassId().getRouteId())
					{
							Bus c =null;
							if(itr.hasNext())
								 c= (Bus)itr.next();
							List<BrtOutputList> tempList = new ArrayList<BrtOutputList>();

							BrtListWithBus outObj = new BrtListWithBus();
							List<Stops> listOfStops=null;
								listOfStops = stopsRepository.findStopsByRouteIdAndBusIdAndTimeLessThanEqualTo(a.getRouteId(),c.getBusId(),b.getStopsClassId().getTime());
								
								
							for (Stops d : listOfStops) {
								BrtOutputList temp = new BrtOutputList();
								temp.setStationName(d.getStation().getStationName());
								temp.setTime(d.getStopsClassId().getTime());
								tempList.add(temp);
							}

							outObj.setBusName(listOfStops.get(0).getBus().getBusName());
							outObj.setTimeTable(tempList);
							outObjList.add(outObj);
					}
				}
			}
			//return outObjList;
		}
		
		//Use Case 3:
		else if(fromInStartStop.isEmpty() && !(toInLastStop.isEmpty()))
		{
			List<Stops> toStopList = stopsRepository.findByStation_StationName(fromTo.getFrom());
			for(Route a: toInLastStop)
			{	
				multipleBus = busRepository.findByRoute_RouteId(a.getRouteId());
				Iterator<Bus> itr = multipleBus.iterator();
				
				for(Stops b: toStopList)
				{
					if(a.getRouteId()==b.getStopsClassId().getRouteId())
					{
							Bus c =null;
							if(itr.hasNext())
								 c= (Bus)itr.next();
							List<BrtOutputList> tempList = new ArrayList<BrtOutputList>();

							BrtListWithBus outObj = new BrtListWithBus();
							List<Stops> listOfStops=null;
								listOfStops = stopsRepository.findStopsByRouteIdAndBusIdAndTimeGreaterThanEqualTo(a.getRouteId(),c.getBusId(),b.getStopsClassId().getTime());
								
							for (Stops d : listOfStops) {
								BrtOutputList temp = new BrtOutputList();
								temp.setStationName(d.getStation().getStationName());
								temp.setTime(d.getStopsClassId().getTime());
								tempList.add(temp);
							}

							outObj.setBusName(listOfStops.get(0).getBus().getBusName());
							outObj.setTimeTable(tempList);
							outObjList.add(outObj);
					}
				}
			}
			//return outObjList;

		}
		
		//Use Case 4:
		else if(fromInStartStop.isEmpty() && toInLastStop.isEmpty())
		{
			List<Stops> fromStopList = stopsRepository.findByStation_StationName(fromTo.getFrom());
			List<Stops> toStopList = stopsRepository.findByStation_StationName(fromTo.getTo());

			for(Stops a: fromStopList)
			{	
				multipleBus = busRepository.findByRoute_RouteId(a.getStopsClassId().getRouteId());
				Iterator<Bus> itr = multipleBus.iterator();
				
				for(Stops b: toStopList)
				{
					if(a.getStopsClassId().getRouteId()==b.getStopsClassId().getRouteId())
					{
							Bus c =null;
							if(itr.hasNext())
								 c= (Bus)itr.next();
							List<BrtOutputList> tempList = new ArrayList<BrtOutputList>();

							BrtListWithBus outObj = new BrtListWithBus();
							List<Stops> listOfStops=null;
								listOfStops = stopsRepository.findByStopsClassId_RouteIdAndBus_BusIdAndStopsClassId_TimeBetween(a.getStopsClassId().getRouteId(),c.getBusId(),a.getStopsClassId().getTime(),b.getStopsClassId().getTime());
								
								
							for (Stops d : listOfStops) {
								BrtOutputList temp = new BrtOutputList();
								temp.setStationName(d.getStation().getStationName());
								temp.setTime(d.getStopsClassId().getTime());
								tempList.add(temp);
							}

							outObj.setBusName(listOfStops.get(0).getBus().getBusName());
							outObj.setTimeTable(tempList);
							outObjList.add(outObj);
					}
				}
			}
			//return outObjList;
		}
		else
		{
			throw new ServicesException("Not Bus found between these Stations");
		}
			return outObjList;
	}
}