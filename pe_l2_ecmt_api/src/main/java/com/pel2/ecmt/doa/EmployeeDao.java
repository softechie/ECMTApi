package com.pel2.ecmt.doa;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pel2.ecmt.constants.Queries;
import com.pel2.ecmt.dto.Employee;

@Component
public class EmployeeDao  {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public Employee getEmployee(String id){
		String sql = "Select id, name, age from employee where id = ?";
		return jdbcTemplate.queryForObject(sql, employeeMapper, new Integer(id));
		
//		String sql = "Select id, name, age from employee where id = '"+id+"'";
//		return jdbcTemplate.queryForObject(sql, employeeMapper);
	}

    private static final RowMapper<Employee> employeeMapper = new RowMapper<Employee>() {
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Employee employee = new Employee();
        	employee.setEmpId(rs.getString("id"));
        	employee.setName(rs.getString("name"));
            return employee;
        }
    };
}
    
    // }
