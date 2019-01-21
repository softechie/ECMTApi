/**
 * 
 */
package com.pel2.ecmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pel2.ecmt.doa.EmployeeDao;
import com.pel2.ecmt.doa.UtilityDao;
import com.pel2.ecmt.dto.Employee;

/**
 * @author vveera1
 *
 */
@RestController
@RequestMapping( value = "/emp")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	UtilityDao utilDao;
	
	
	@RequestMapping(value = "/details" , method = RequestMethod.POST)
	public Employee getEmpDetails(@RequestBody String id){
		return employeeDao.getEmployee(id);
	}	
	
	@RequestMapping(value = "/settables" , method = RequestMethod.GET)
	public String doCreateTables (){
		System.out.println("Entering the table creation procedure");
		return utilDao.doCreateTables(); 
	}	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public Employee addEmployee(@RequestBody Employee emp ) 
	{
		utilDao.addEmployee(emp);
		return new Employee();
	}
	
	
}
