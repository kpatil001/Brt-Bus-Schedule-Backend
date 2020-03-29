package com.brt.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.brt.domain.BaseWrapper;
import com.brt.domain.ResponseMessage;



public class ExceptionUtility {

	public Object invalidExceptionMsg(String msg)
	{
		
		ResponseMessage responseMessage = new ResponseMessage(401,msg);
		BaseWrapper response = new BaseWrapper(responseMessage); 
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}
}
