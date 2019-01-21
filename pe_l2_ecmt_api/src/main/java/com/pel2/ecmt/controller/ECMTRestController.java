package com.pel2.ecmt.controller;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class ECMTRestController 
{/*
//	@Autowired
//	Dao ebatch;
	
	@Autowired
	EcmtHashBatch ebatch;
	
	@Autowired
	BatchProcessorService batchProcessor;
	
	@Autowired
	StoreDeletedEmployeeService employeeService;
	
	@RequestMapping(value = "/deleteComment/{key}", method = RequestMethod.GET)
	public ResponseEntity<Void> deleteComment(@PathVariable("key") String key) 
	{
		if (ebatch.deleteComment(key))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}/{reason}/{reasonComment}/{generalComment}"
			, method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Void> deleteEmployee(@RequestBody TerminationInfo termInfo, 
			@PathVariable("id") String id, @PathVariable("reason") String reason, 
			@PathVariable("reasonComment") String reasonComment, 
			@PathVariable("generalComment") String generalComment) 
	{
		TerminationInfo term = new TerminationInfo(reason, reasonComment, generalComment);
		if(employeeService.storeEmployee(id, term))
		{
			if(ebatch.deleteEmployee(id))
				return new ResponseEntity<Void>(HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/deleteSkill/{type}/{key}", method = RequestMethod.GET)
	public ResponseEntity<Void> deleteSkill(@PathVariable("type") String type, @PathVariable("key") String key) 
	{
		if (ebatch.deleteSkill(key, type))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getAccounts/{id}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<DropdownObj>> getAccounts(@PathVariable("id") String id) 
	{
		ArrayList<DropdownObj> acc = ebatch.getAccounts(id);
		
		if(acc != null)
			return new ResponseEntity<ArrayList<DropdownObj>>(acc, HttpStatus.OK);
		else
			return new ResponseEntity<ArrayList<DropdownObj>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getAccountSPOC/{id}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Spoc>> getAccountSPOC(@PathVariable("id") String id) 
	{
		ArrayList<Spoc> vs = ebatch.getAccountSPOC(id);
		
		if(vs != null)
			return new ResponseEntity<ArrayList<Spoc>>(vs, HttpStatus.OK);
		else
			return new ResponseEntity<ArrayList<Spoc>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getReport/{option}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Employee>> getAllEmployees(@PathVariable("option") String option) 
	{
		ArrayList<Employee> newEmps = null;
		
		if(option.equals("All Employees"))
			newEmps = ebatch.getAllEmployees();
		else 
			newEmps = ebatch.getStatus(option);
		
		if(newEmps != null)
			return new ResponseEntity<ArrayList<Employee>>(newEmps, HttpStatus.OK);
		else
			return new ResponseEntity<ArrayList<Employee>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profile> getName(@PathVariable("id") String id) 
	{
		Profile employee = ebatch.getEmployee(id);
		
		if(employee != null)
			return new ResponseEntity<Profile>(employee, HttpStatus.OK);
		else
			return new ResponseEntity<Profile>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getReportTenure/{start}/{end}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Employee>> getReportTenure(@PathVariable("start") String start, @PathVariable("end") String end) 
	{
		ArrayList<Employee> employees = ebatch.getEmployeesByTenure(start, end);
		
		if(employees != null)
			return new ResponseEntity<ArrayList<Employee>>(employees, HttpStatus.OK);
		else
			return new ResponseEntity<ArrayList<Employee>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getReportSkill", method = RequestMethod.POST,	consumes = "application/json")
	public ResponseEntity<ArrayList<Employee>> getSkillReport(@RequestBody String skill) 
	{
		ArrayList<Employee> employees = ebatch.getEmployeesBySkill(skill);
		
		if(employees != null)
			return new ResponseEntity<ArrayList<Employee>>(employees, HttpStatus.OK);
		else
			return new ResponseEntity<ArrayList<Employee>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getVerticalAccount", method = RequestMethod.GET)
	public ResponseEntity<TotalVertAcc> getVerticalAccount() 
	{
		TotalVertAcc vt = ebatch.getVerticalAccount();
		
		if(vt != null)
			return new ResponseEntity<TotalVertAcc>(vt, HttpStatus.OK);
		else
			return new ResponseEntity<TotalVertAcc>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/getVerticalSPOC/{id}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Spoc>> getVerticalSPOC(@PathVariable("id") String id) 
	{
		ArrayList<Spoc> vs = ebatch.getVerticalSPOC(id);
		
		if(vs != null)
			return new ResponseEntity<ArrayList<Spoc>>(vs, HttpStatus.OK);
		else
			return new ResponseEntity<ArrayList<Spoc>>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/addComment", method = RequestMethod.POST,	consumes = "application/json")
	public ResponseEntity<Comment> insertComment(@RequestBody Comment comment) 
	{
		Comment newComment = ebatch.insertComment(comment);
		
		if(newComment != null)
			return new ResponseEntity<Comment>(newComment, HttpStatus.OK);
		else
			return new ResponseEntity<Comment>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST,	consumes = "application/json")
	public ResponseEntity<Void> insertEmployee(@RequestBody Employee employee) 
	{
		if( ebatch.insertEmployee(employee))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/addBatch", method = RequestMethod.POST)
	public ResponseEntity<Void> insertEmployeeBatch(@RequestBody String batch) 
	{
		if (batchProcessor.processBatch(batch))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/addEmpVertical/{id}", method = RequestMethod.POST,	consumes = "application/json")
	public ResponseEntity<Void> insertEmpVertical(@RequestBody Vertical vertical, @PathVariable("id") String id ) 
	{
		if( ebatch.insertEmpVertical(vertical,id))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/addEmpAccount/{id}", method = RequestMethod.POST,	consumes = "application/json")
	public ResponseEntity<Void> insertEmpAccount(@RequestBody Account account, @PathVariable("id") String id) 
	{
		if( ebatch.insertEmpAccount(account,id))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value = "/addSkill/{type}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Skill> insertSkill(@RequestBody Skill skill, @PathVariable("type") String type) 
	{
		Skill newSkill = ebatch.insertSkill(skill, type);
		
		if(newSkill != null)
			return new ResponseEntity<Skill>(newSkill, HttpStatus.OK);
		else
			return new ResponseEntity<Skill>(HttpStatus.BAD_REQUEST);
	}


	@RequestMapping(value = "/insertHistory/{empId}/{changes}", method = RequestMethod.POST)
	public ResponseEntity<History> insertHistory(@PathVariable("empId") String id, @PathVariable("changes") String changes) throws SQLException, ClassNotFoundException 
	{
		if (ebatch.insertHistory(id, changes)){
			History hist = new History();
			Class.forName("org.sqlite.JDBC");
			String dbURL = Constants.DBURL;
			Connection conn = DriverManager.getConnection(dbURL);
			PreparedStatement ps = conn.prepareStatement(Queries.SELECTHISTORYDETAILS);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();	
			while(rs.next())
			{
				Comment cmt = new Comment();
				
				cmt.setComment(rs.getString("comment"));
				cmt.setDate(rs.getString("date"));
				
				hist.addComment(cmt);
			}
			dao.connectionsClose(conn, ps, rs);
			
			return new ResponseEntity<History>(hist,HttpStatus.OK);
		}
		else
			return new ResponseEntity<History>(HttpStatus.BAD_REQUEST);
	}


	@RequestMapping(value = "/updateAccount/{id}", method = RequestMethod.POST)
	public ResponseEntity<StringBuilder> updateAccount(@PathVariable("id") String id, @RequestBody Account account) 
	{
		String history =  ebatch.checkEmpAccountHistory(id, account);
		if(!history.equals(""))
			history+=", ";
		if (ebatch.updateAccount(account, id))
			return new ResponseEntity<StringBuilder>(new StringBuilder(history), HttpStatus.OK);
		else
			return new ResponseEntity<StringBuilder>(HttpStatus.BAD_REQUEST);
	}


	@RequestMapping(value = "/updateComment", method = RequestMethod.POST)
	public ResponseEntity<Void> updateComment(@RequestBody Comment comment) 
	{
		if (ebatch.updateComment(comment))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ResponseEntity<StringBuilder> updateEmployee(@RequestBody Employee employee) 
	{
		String history  = ebatch.checkEmpHistory(employee);
		if(!history.equals(""))
			history+=", ";
		
		if (ebatch.updateEmployee(employee))
			return new ResponseEntity<StringBuilder>(new StringBuilder(history), HttpStatus.OK);
		else
			return new ResponseEntity<StringBuilder>(HttpStatus.BAD_REQUEST);
	}


	@RequestMapping(value = "/updateRM/{id}", method = RequestMethod.POST)
	public ResponseEntity<StringBuilder> updateRM(@PathVariable("id") String id, @RequestBody RM rm) 
	{
		String history = ebatch.checkRMHistory(id,rm);
		if(!history.equals(""))
			history+=", ";
		if (ebatch.updateRM(rm, id))
			return new ResponseEntity<StringBuilder>(new StringBuilder(history), HttpStatus.OK);
		else
			return new ResponseEntity<StringBuilder>(HttpStatus.BAD_REQUEST);
	}


	@RequestMapping(value = "/updateSkill/{type}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateSkill(@RequestBody Skill skill, @PathVariable("type") String type) 
	{
		if (ebatch.updateSkill(skill, type))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value = "/updateVertical/{id}", method = RequestMethod.POST)
	public ResponseEntity<StringBuilder> updateVertical(@PathVariable("id") String id, @RequestBody Vertical vertical) 
	{
		String history =  ebatch.checkEmpVerticalHistory(id,vertical);
		if(!history.equals(""))
			history+=", ";
		if (ebatch.updateVertical(vertical, id))
			return new ResponseEntity<StringBuilder>(new StringBuilder(history), HttpStatus.OK);
		else
			return new ResponseEntity<StringBuilder>(HttpStatus.BAD_REQUEST);
	}
*/}
