package com.pel2.ecmt.doa;

import com.pel2.ecmt.dto.Employee;

public interface IEmployeeDao  {

	public Employee addEmployee(Employee e);
	public Employee deleteEmployee(Employee e);
	public String updateEmployee(Employee e);
	public Employee searchEmployee(String employid);
}
