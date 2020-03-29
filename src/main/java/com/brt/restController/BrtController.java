package com.brt.restController;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brt.domain.BaseWrapper;
import com.brt.domain.BrtListWithBus;
import com.brt.domain.BrtWrapper;
import com.brt.domain.FromTo;
import com.brt.domain.ResponseMessage;
import com.brt.exception.ServicesException;
import com.brt.model.Bus;
import com.brt.model.LoginDtls;
import com.brt.model.Route;
import com.brt.model.Stops;
import com.brt.model.UserDtls;
import com.brt.service.BrtService;
import com.brt.util.ExceptionUtility;

@RestController
public class BrtController {

	@Autowired
	private BrtService brtService;
	
	@RequestMapping(value="/getString", method = RequestMethod.GET)
	public String getString()
	{
		return "Welcome Back";
	}
	
	private ExceptionUtility exceptionUtility = new ExceptionUtility();
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object addRecord(@RequestBody UserDtls userDtls) {
		try {
				brtService.addRecordService(userDtls);
				ResponseMessage responseMessage = new ResponseMessage(200,"Record added Successfully");
				BaseWrapper response = new BaseWrapper(responseMessage); 
				return new ResponseEntity<Object>(response,HttpStatus.OK);
			} 
		catch(ServicesException e){
			return exceptionUtility.invalidExceptionMsg (e.getMessage());
		}
		catch (ServiceException e) {
			return exceptionUtility.invalidExceptionMsg (e.getMessage());
		}
		catch(Exception e){
			return exceptionUtility.invalidExceptionMsg (e.getMessage());
		}
		
	}
	
	@RequestMapping(value="/get-record/{id}",method=RequestMethod.GET)
	public Optional<UserDtls> getRecord(@PathVariable("id")int id)
	{
		return brtService.getRecordService(id);
	}
	
	
	@RequestMapping(value="/get-route/{id}",method=RequestMethod.GET)
	public Optional<Route> getRoute(@PathVariable("id")int id)
	{
		
		return brtService.getRouteService(id);
	}
	
	@RequestMapping(value="/get-stop/{id}",method=RequestMethod.GET)
	public List<Stops> getStop(@PathVariable("id")int id)
	{
		
		return brtService.getStopService(id);
	}
	
	@RequestMapping(value="/tryResult",method=RequestMethod.GET)
	public List<Bus> tryResult()
	{
		return brtService.tryFunc(1);
	}
	
	
	
	@RequestMapping(value = "/check-login", method = RequestMethod.POST)
	public Object checkLogin(@RequestBody LoginDtls loginDtls) {
		try {
			brtService.checkLoginService(loginDtls);
			ResponseMessage responseMessage = new ResponseMessage(200, "Login Successful");
			BaseWrapper response = new BaseWrapper(responseMessage);
			return new ResponseEntity<Object>(response, HttpStatus.OK);

		} catch (ServicesException e) {
			return exceptionUtility.invalidExceptionMsg(e.getMessage());
		} catch (ServiceException e) {
			return exceptionUtility.invalidExceptionMsg(e.getMessage());
		} catch (Exception e) {
			return exceptionUtility.invalidExceptionMsg(e.getMessage());
		}

	}
	
	
	@RequestMapping(value="/fetch-time-table",method=RequestMethod.POST)
	public Object fetchTimeTable(@RequestBody FromTo fromTo)
	{
		try {
			List<BrtListWithBus> output = brtService.fetchTimeTableService(fromTo);
			ResponseMessage responseMessage = new ResponseMessage(200, "Record Fetch successful");
			BrtWrapper response = new BrtWrapper(responseMessage, output);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (ServicesException e) {
			return exceptionUtility.invalidExceptionMsg(e.getMessage());
		}
	}
	

	

}
