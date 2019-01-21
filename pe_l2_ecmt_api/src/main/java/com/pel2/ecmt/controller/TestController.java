/**
 * 
 */
package com.pel2.ecmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pel2.ecmt.bean.Name;
import com.pel2.ecmt.doa.EmployeeDao;
import com.pel2.ecmt.dto.Employee;
import com.pel2.ecmt.service.ITest;

/**
 * @author akuppura
 *
 */
@RestController
@RequestMapping( value = "/Employee")
public class TestController {
	
	
	@Autowired
	ITest test;
	
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public Name getName(){
		
		return test.getName();
	}
	
	@RequestMapping(value = "/address" , method = RequestMethod.POST)
	public Name getAddress(@RequestBody String customer){
		return test.getAddress(customer);
	}
	
	@RequestMapping(value = "/details" , method = RequestMethod.POST)
	public String getDetails(@RequestBody String id){
		return test.getDetails(id);
	}
}
