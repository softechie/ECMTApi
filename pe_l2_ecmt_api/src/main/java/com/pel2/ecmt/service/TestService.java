package com.pel2.ecmt.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.pel2.ecmt.bean.Name;

@Service
public class TestService implements ITest{

	public Name getName() {
		
		Name name = new Name();
		name.setAge("12");
		name.setName("abc");
		return name;
	}

	public Name getAddress(String customerId) {
		
		Name name = new Name();
		name.setAge("15");
		name.setName("sdhs");
		return name;
	}
	public String getDetails(String id){
		//Name name = new Name();
		HashMap<String,String> d= new HashMap<String,String>();
		d.put("1", "ash");
		d.put("2", "af45sh");
		d.put("3", "fdf");
		System.out.println(id+','+d.get(id));
		return d.get(id);
	}

	public String addEmployee(String id, String name) {
		return null;
	}

	public String getEmployee(String id) {
		return null;
	}	
	}
	
	
	