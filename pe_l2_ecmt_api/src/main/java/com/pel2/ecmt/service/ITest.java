package com.pel2.ecmt.service;

import com.pel2.ecmt.bean.Name;

public interface ITest {

	public Name getName();

	public Name getAddress(String customerId);
	
	public String getDetails(String id);
	
	public String addEmployee(String id, String name);
	
	public String getEmployee(String id);
	
}
