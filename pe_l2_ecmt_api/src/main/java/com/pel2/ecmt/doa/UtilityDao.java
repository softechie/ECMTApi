package com.pel2.ecmt.doa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pel2.ecmt.constants.Queries;
import com.pel2.ecmt.dto.Employee;

/**
 * @author vveera1
 *
 */

@Component
public class UtilityDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
//the Create Table module has to be called once from the postman
    
    public String doCreateTables(){
    	Queries qryacct = new Queries();
    	try{
    	String sql = qryacct.CREATEEMPLOYEE;
		jdbcTemplate.execute(sql);
		System.out.println("Employee Table Created");
    	}catch (Exception se){
    		System.out.println("Employee Table NOT Created");
    	}
    	try{
        	String sql = qryacct.CREATEACCOUNT;
    		jdbcTemplate.execute(sql);
    		System.out.println("Account Table Created");
        	}catch (Exception se){
        		System.out.println("Account Table NOT Created");
        	}
    	try{
        	String sql = qryacct.CREATEVERTICAL;
    		jdbcTemplate.execute(sql);
    		System.out.println("Vertical Table Created");
        	}catch (Exception se){
        		System.out.println("Veritical Table NOT Created");
        	}

    	try{
        	String sql = qryacct.CREATEROLE;
    		jdbcTemplate.execute(sql);
    		System.out.println("Role Table Created");
        	}catch (Exception se){
        		System.out.println("Role Table NOT Created");
        	}
    		return "Success";
    	}
	
    public String addEmployee(Employee emp){
    	Queries qryacct = new Queries();
    	try{
    	String sql = qryacct.INSERTEMPLOYEE;
		jdbcTemplate.update(sql, new Object[]{emp.getEmpId(), emp.getName(),emp.getStatus(),emp.getTenure(),emp.getPhone(),emp.getEmail(),emp.getDoj(),emp.getWl(),emp.getHl(),emp.getCl(),emp.getRmid(),emp.getRoleid(),emp.getVertid(),emp.getAcctid()});
		System.out.println("Employee Record  Inserted");
    	}catch (Exception se){
    		System.out.println("Employee Record NOT Inserted");
    	}
    	return "Success";
    }
    
}
