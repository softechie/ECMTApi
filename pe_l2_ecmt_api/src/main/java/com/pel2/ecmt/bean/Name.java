package com.pel2.ecmt.bean;

import java.util.HashMap;

public class Name {

	private String name;
	private String age;
	private String dummy;

	private HashMap<String,String> empmap = new HashMap<String,String>();

	/*public String getDetails(String id){
		 String a = empmap.get(id);
		 dummy=a;
		 return a;
	}
	
	public void setmap(String id,String name){
		this.empmap.put(id,name);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}*/
	
	

	
	@Override
	public String toString() {
		return "Name [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

	public HashMap<String, String> getEmpmap() {
		return empmap;
	}

	public void setEmpmap(HashMap<String, String> empmap) {
		this.empmap = empmap;
	}


}
