package com.pel2.ecmt.constants;

public class EcmtHashBatch {/*

	public static HashMap<String, Employee> emphash = new HashMap<String, Employee>();
	public static HashMap<String, Account> accthash = new HashMap<String, Account>();
	public static HashMap<String, Vertical> verthash = new HashMap<String, Vertical>();
	public static HashMap<String, RM> rmhash = new HashMap<String, RM>();
	public static HashMap<String, EmpSkills> skillhash = new HashMap<String, EmpSkills>();
	public static HashMap<String, TrainedEmpSkills> skilltrng = new HashMap<String, TrainedEmpSkills>();
	public static HashMap<String, History> hishash = new HashMap<String, History>();
	public static TotalVertAcc ttlVertAcc = new TotalVertAcc();
	
	public static HashMap<String, ArrayList<Spoc>> vertSpochash = new HashMap<String, ArrayList<Spoc>>();
	
	public static int vertId = 4000;
	public static int accId = 8000;
	public static int spocId = 5000;
	public static int hisId = 6000;
	public static int comId = 7000;
	
	public EcmtHashBatch(){
		createTotalVertAcc();
		getVerticalSPOC();
	}

	public static void createTotalVertAcc(){
		DropdownObj vert1 = new DropdownObj();
		vert1.setId(new Integer(vertId++).toString());
		vert1.setName("BNFS");
		ttlVertAcc.addVertDetails(vert1);		
		
		DropdownObj acc1 = new DropdownObj();
		acc1.setId(new Integer(accId++).toString());
		acc1.setName("Amex");
		ttlVertAcc.addAccDetails(acc1);
		
		DropdownObj acc2 = new DropdownObj();
		acc2.setId(new Integer(accId++).toString());
		acc2.setName("Fedex");
		ttlVertAcc.addAccDetails(acc2);
	}
	
	public static void getVerticalSPOC(){
		ArrayList<Spoc> result = new ArrayList<Spoc>();
		
		Spoc spoc1 = new Spoc();
		
		spoc1.setName("Charuhas");
		spoc1.setPhone("602-537-5054");
		spoc1.setEmail("Charuhas@gmail.com");
		spoc1.setId(new Integer(spocId++).toString());
		
		result.add(spoc1);
		vertSpochash.put(ttlVertAcc.getVertDetails().get(0).getId(), result);

	}
	
	public boolean insertEmployee(Employee emp) {
		boolean result = true;
		try {
			emphash.put(emp.getEmpId(), emp);

			Account account = new Account();
			account.getAccount().setName("AMEX " + emp.getEmpId());
			account.getSpoc().setName("PDAC Account " + emp.getEmpId());
			account.getSpoc().setPhone("602-537-0000");
			account.getSpoc().setEmail("acctspoc" + emp.getEmpId() + "@gmail.com");
			account.getAccount().setId(emp.getEmpId());

			accthash.put(emp.getEmpId(), account);

			Vertical vertical = new Vertical();
			vertical.getVertical().setName("BNFS");
			vertical.getSpoc().setName("PDAC Vertical");
			vertical.getSpoc().setPhone("602-537-0000");
			vertical.getSpoc().setEmail("vertspoc@gmail.com");
			vertical.getVertical().setId(emp.getEmpId());

			verthash.put(emp.getEmpId(), vertical);

			// Populate the RM data
			RM rm = new RM();
			rm.setRm("Manager01"+emp.getEmpId());
			rm.setPhone("602-537-0000");
			rm.setEmail("manager01"+emp.getEmpId()+"@gmail.com");
			rmhash.put(emp.getEmpId(), rm);

			// Populate Skills
			ArrayList<EmpSkills> askills = new ArrayList<EmpSkills>();

			EmpSkills empskills = new EmpSkills();
			empskills.setEmpId(emp.getEmpId());

			ArrayList<Skill> arrSkills = new ArrayList<Skill>();

			Skill skills = new Skill();
			skills.setKey("1");
			skills.setEmpId(emp.getEmpId());
			skills.setSkillName("Mainframe");
			arrSkills.add(skills);

			Skill skills1 = new Skill();
			skills1.setKey("2");
			skills1.setEmpId(emp.getEmpId());
			skills1.setSkillName("Java");
			arrSkills.add(skills1);

			empskills.setSkills(arrSkills);
			skillhash.put(emp.getEmpId(), empskills);

			// Populate Training Skills
			//ArrayList<TrainedEmpSkills> atrgskills = new ArrayList<TrainedEmpSkills>();

			TrainedEmpSkills trainedempskills = new TrainedEmpSkills();
			trainedempskills.setEmpId(emp.getEmpId());

			ArrayList<Skill> trgskills = new ArrayList<Skill>();

			Skill tskills1 = new Skill();
			tskills1.setKey("1");
			tskills1.setEmpId(emp.getEmpId());
			tskills1.setSkillName("Project Management");
			trgskills.add(tskills1);

			Skill tskills2 = new Skill();
			tskills2.setKey("2");
			tskills2.setEmpId(emp.getEmpId());
			tskills2.setSkillName("Communication Skills");
			trgskills.add(tskills2);

			trainedempskills.setSkills(trgskills);
			skilltrng.put(emp.getEmpId(), trainedempskills);

		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
			result = false;
		}
		return result;
	}

	public ArrayList<Spoc> getVerticalSPOC(String idname, String str) {
		ArrayList<Spoc> result = new ArrayList<Spoc>();
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Spoc spoc1 = new Spoc();
			spoc1.setId(new Integer(spocId++).toString());
			spoc1.setName(idname);
			spoc1.setPhone("602-537-" + spoc1.getId());
			spoc1.setEmail("acctspoc" + spoc1.getId() + "@gmail.com");
			result.add(spoc1);
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Spoc> getVerticalSPOC(String id) {		
		return vertSpochash.get(id);
	}

	public TotalVertAcc getVerticalAccount(String idname) {
		TotalVertAcc result = new TotalVertAcc();
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			DropdownObj vert = new DropdownObj();
			vert.setId(new Integer(vertId++).toString());
			vert.setName(idname);
			result.addVertDetails(vert);
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return result;
	}

	public TotalVertAcc getVerticalAccount() {
		return ttlVertAcc;
	}

	public boolean insertEmpVertical(Vertical vertical, String id) {
		verthash.put(id, vertical);
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		return true;
	}

	public boolean insertEmpAccount(Account account, String id) {
		accthash.put(id, account);
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		return true;
	}

	public boolean insertHistory(String id, String changes) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (hishash.containsKey(id)) {
			hishash.get(id)
					.addComment(new Comment(id, new Date().toString(), changes, new Integer(comId++).toString()));
		} else {
			ArrayList<Comment> comment = new ArrayList<Comment>();
			comment.add(new Comment(id, new Date().toString(), changes, new Integer(comId++).toString()));
			hishash.put(id, new History(new Integer(hisId++).toString(), id, comment));
		}
		return true;
	}

	public Skill insertSkill(Skill skill, String type) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			if (skillhash.containsKey(skill.getEmpId())) {
				skillhash.get(skill.getEmpId()).getSkills().add(skill);
			} else {
				ArrayList<Skill> skillArr = new ArrayList<Skill>();
				skillArr.add(skill);
				skillhash.put(skill.getEmpId(), new EmpSkills(skill.getEmpId(), skillArr));
			}
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
		}
		return skill;
	}

	public boolean deleteComment(String key) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		return true;
	}

	public ArrayList<DropdownObj> getAccounts(String id) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		ArrayList<DropdownObj> acc = new ArrayList<DropdownObj>();
		try {
			acc.add(new DropdownObj("0", "Not Assigned"));

			if (!id.equals("0")) {
				DropdownObj obj = new DropdownObj();
				obj.setId("aid");
				obj.setName("Name");
				acc.add(obj);
			}
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return acc;
	}

	public ArrayList<Spoc> getAccountSPOC(String id) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		ArrayList<Spoc> result = new ArrayList<Spoc>();
		Utilities.LOG.info("Entering the Class:" + this.getClass().toString());
		try {
			Spoc spoc = new Spoc();
			spoc.setId("sid");
			spoc.setName("name");
			spoc.setPhone("phone");
			spoc.setEmail("email");
			result.add(spoc);
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return result;
	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		try {
			// ResultSet rs = stmt.executeQuery(Queries.SELECTALLEMPLOYEES);
			setEmpDetails(employees);
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return employees;
	}

	public Profile getEmployee(String empId) {
		Account account = new Account();
		Comments comments = new Comments();
		Employee employee = new Employee();
		EmpSkills empSkills = new EmpSkills();
		History history = new History();
		TrainedEmpSkills trainedEmpSkills = new TrainedEmpSkills();
		Vertical vertical = new Vertical();
		Profile profile = new Profile();
		RM rm = new RM();
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		employee = emphash.get(empId);
		account = accthash.get(empId);
		vertical = verthash.get(empId);
		rm = rmhash.get(empId);
		empSkills = skillhash.get(empId);
		trainedEmpSkills = skilltrng.get(empId);

		profile.setAccount(account);
		profile.setVertical(vertical);
		profile.setEmployee(employee);
		profile.setHistory(history);
		profile.setComments(comments);
		profile.setSkills(empSkills);
		profile.setTrainings(trainedEmpSkills);
		profile.setRm(rm);

		return profile;
	}

	public void getHistory(String empId, History history) {
		// fetching History info
		// ps = conn.prepareStatement(Queries.SELECTHISTORYDETAILS);
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		history = hishash.get(empId);
	}

	public ArrayList<Employee> getEmployeesBySkill(String skill) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		// skill = "%" + skill + "%";
		try {
			// ps = conn.prepareStatement(Queries.SELECTSKILL);
			setEmpDetails(employees);
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return employees;
	}

	public ArrayList<Employee> getEmployeesByTenure(String start, String end) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			// ps = conn.prepareStatement(Queries.SELECTTENURE);
			setEmpDetails(employees);
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return employees;
	}

	public ArrayList<Employee> getStatus(String option) {
		String status = "%" + option + "%";
		String training = "%training%";
		String si = "%si%";
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			if (option.equalsIgnoreCase("bench")) {
				// ps = conn.prepareStatement(Queries.SELECTSTATUSEXTRATYPE);
				setEmpDetails(employees);
			} else if (option.equalsIgnoreCase("buffer")) {
				// ps = conn.prepareStatement(Queries.SELECTSTATUSEXTRATYPE);
				setEmpDetails(employees);
			} else if (option.equalsIgnoreCase("non-billable")) {
				// ps = conn.prepareStatement(Queries.SELECTNONBILLABLESTATUS);
				setEmpDetails(employees);
			} else {
				// ps = conn.prepareStatement(Queries.SELECTSTATUSTYPE);
				setEmpDetails(employees);
			}
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return employees;
	}

	public Comment insertComment(Comment comment) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		
		try {
			hishash.get(comment.getEmpId()).addComment(comment);
			// ps = conn.prepareStatement(Queries.INSERTCOMMENT);
		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}
		return comment;
	}

	public boolean insertPreviousEmployee(Profile profile, TerminationInfo termInfo) {
		boolean bool = true;
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			// ps = con.prepareStatement(Queries.INSERTPREVIOUSEMPLOYEE);
			// ps.setString(1, profile.getEmployee().getEmpId());
			// ps.setString(2, profile.getEmployee().getName());
			// ps.setString(3, profile.getEmployee().getStatus());
			// ps.setString(4, profile.getEmployee().getDoj());
			// ps.setString(5, profile.getEmployee().getTenure());
			// ps.setString(6, profile.getEmployee().getPhone());
			// ps.setString(7, profile.getEmployee().getEmail());
			// ps.setString(8, profile.getEmployee().getWtr());
			// ps.setString(9, profile.getEmployee().getWl());
			// ps.setString(10, profile.getEmployee().getHl());
			// ps.setString(11, profile.getVertical().getVertical().getName());
			// ps.setString(12, profile.getAccount().getAccount().getName());
			// ps.setString(13, profile.getRm().getRm());
			// ps.setString(14, profile.getRm().getPhone());
			// ps.setString(15, profile.getRm().getEmail());
			// ps.setString(16, profile.getTrainings().returnSkills());
			// ps.setString(17, termInfo.getReasonForLeaving());
			// ps.setString(18, termInfo.getReasonComment());
			// ps.setString(19, termInfo.getGeneralComment());
			bool = false;
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
			bool = false;
		}
		return bool;
	}

	public boolean updateAccount(Account account, String empId) {
		boolean result = true;
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			accthash.get(empId).getAccount().setId(account.getAccount().getId());
			// ps = conn.prepareStatement(Queries.UPDATEACCOUNTTABLE);
			// ps = conn.prepareStatement(Queries.UPDATEEMPLOYEEACCOUNT);
			result = false;
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean updateComment(Comment comment) {
		boolean bool = true;
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			// hishash.get(comment.getEmpId()).getComments().(comment.getEmpId()).

			// ps = conn.prepareStatement(Queries.UPDATECOMMENT);
			// ps.setString(1, comment.getComment());
			// ps.setString(2, comment.getDate());
			// ps.setString(3, comment.getCommentId());

			bool = false;
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
			bool = false;
		}
		return bool;
	}

	public boolean updateEmployee(Employee employee) {

		boolean result = true;
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			// ps = conn.prepareStatement(Queries.UPDATEMPLOYEEDETAILS);
			// ps.setString(1, employee.getEmpId());
			// ps.setString(2, employee.getName());
			// ps.setString(3, employee.getStatus());
			// ps.setString(4, employee.getDoj());
			// ps.setString(5, employee.getTenure());
			// ps.setString(6, employee.getWl());
			// ps.setString(7, employee.getCl());
			// ps.setString(8, employee.getHl());
			// ps.setString(9, employee.getPhone());
			// ps.setString(10, employee.getEmail());
			// ps.setString(11, employee.getWtr());
			// ps.setString(12, employee.getEmpId());

			result = false;
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean updateRM(RM rm, String empId) {

		boolean result = true;
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {

			// ps = conn.prepareStatement(Queries.UPDATEEMPLOYEERM);
			// ps.setString(1, rm.getRm());
			// ps.setString(2, rm.getPhone());
			// ps.setString(3, rm.getEmail());
			// ps.setString(4, empId);

			result = false;
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean updateSkill(Skill skill, String type) {
	//	Connection con;
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		boolean result = true;

		try {

			// if (type.equals("skill"))
			// ps = con.prepareStatement(Queries.UPDATESKILL);
			// else
			// ps = con.prepareStatement(Queries.UPDATETRAININGSKILL);
			//
			// ps.setString(1, skill.getSkillName());
			// ps.setString(2, skill.getKey());

			result = false;
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean updateVertical(Vertical vertical, String empId) {
		boolean result = true;
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			// stmt.executeUpdate("UPDATE VERTICAL SET vid=" +
			// vertical.getVertical().getId() + " WHERE empID=" + empId);

			// ps = conn.prepareStatement(Queries.UPDATEEMPLOYEEVERTICAL);
			// ps.setString(1, vertical.getSpoc().getId());
			// ps.setString(2, empId);

			result = false;
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
			result = false;
		}
		return result;
	}

	private void fetchOldAccDetails(String id, Account acc) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			// fetching Vertical info
			// ps = conn.prepareStatement(Queries.SELECTACCOUNTINFORMATION);
			// ps.setString(1, id);
			//
			// if (rs.next()) {
			// acc.getAccount().setName(rs.getString("ACCOUNT"));
			// acc.getSpoc().setName(rs.getString("ACC_SPOC_NAME"));
			// acc.getSpoc().setPhone(rs.getString("ACC_SPOC_PHONE"));
			// acc.getSpoc().setEmail(rs.getString("ACC_SPOC_EMAIL"));
			// acc.getAccount().setId(rs.getString("ID"));
			// }

		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
		}

	}

	private void fetchOldEmpDetails(String id, Employee emp) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			emp = emphash.get(id);
			// fetching Employee info
			// ps = conn.prepareStatement(Queries.SELECTEMPLOYEEINFORMATION);
			// ps.setString(1, id);
			// rs = ps.executeQuery();
			//
			// emp.setEmpId(rs.getString("empID"));
			// emp.setName(rs.getString("name"));
			// emp.setStatus(rs.getString("status"));
			// emp.setPhone(rs.getString("phone"));
			// emp.setDoj(rs.getString("DateofJoining"));
			// emp.setCl(rs.getString("currentLocation"));
			// emp.setHl(rs.getString("homeLocation"));
			// emp.setWl(rs.getString("workLocation"));
			// emp.setEmail(rs.getString("email"));
			// emp.setWtr(rs.getString("wtr"));
			// emp.setTenure(rs.getString("tenure"));
		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
		}
	}

	private void fetchOldVertDetails(String id, Vertical vert) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			// fetching Vertical info
			// ps = conn.prepareStatement(Queries.SELECTVERTICALINFORMATION);
			// ps.setString(1, id);
			// vert.getVertical().setName(rs.getString("VERTICAL"));
			// vert.getSpoc().setName(rs.getString("VERT_SPOC_NAME"));
			// vert.getSpoc().setPhone(rs.getString("VERT_SPOC_PHONE"));
			// vert.getSpoc().setEmail(rs.getString("VERT_SPOC_EMAIL"));
			// vert.getVertical().setId(rs.getString("ID"));

		} catch (Exception e1) {
			System.out.println(" Exception");
			e1.printStackTrace();
		}
	}

	private void fetchOldRmDetails(String id, RM rm) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		try {
			// fetching Vertical info
			// ps = conn.prepareStatement(Queries.SELECTEMPLOYEEINFORMATION);
			// ps.setString(1, id);
			//
			// rm.setRm(rs.getString("reportingManager"));
			// rm.setPhone(rs.getString("reportingManagerPhone"));
			// rm.setEmail(rs.getString("reportingManagerEmail"));

		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
		}

	}

	public String checkRMHistory(String id, RM rm) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		String changes = "";
		ArrayList<String> listOfChanges = new ArrayList<String>();
		RM oldRm = new RM();
		fetchOldRmDetails(id, oldRm);
		if (oldRm.getRm() != null) {
			if (!oldRm.getRm().equalsIgnoreCase(rm.getRm()))
				listOfChanges.add("RM name(" + oldRm.getRm() + " to " + rm.getRm() + ")");
			if (oldRm.getPhone() == null || !oldRm.getPhone().equalsIgnoreCase(rm.getPhone()))
				listOfChanges.add("RM phone(" + oldRm.getPhone() + " to " + rm.getPhone() + ")");
		}
		changes += listOfChanges.toString().replace("[", "").replace("]", "");
		return changes;
	}

	public String checkEmpHistory(Employee employee) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		String changes = "";
		scrubDate(employee.getTenure(), employee);
		scrubDOJDate(employee.getDoj(), employee);
		ArrayList<String> listOfChanges = new ArrayList<String>();
		Employee emp = new Employee();
		fetchOldEmpDetails(employee.getEmpId(), emp);

		if (!employee.getEmpId().equalsIgnoreCase(emp.getEmpId()))
			listOfChanges.add("Employee ID");
		if (!employee.getName().equalsIgnoreCase(emp.getName()))
			listOfChanges.add("Name(" + emp.getName() + " to " + employee.getName() + ")");
		if (!employee.getStatus().equalsIgnoreCase(emp.getStatus()))
			listOfChanges.add("Status(" + emp.getStatus() + " to " + employee.getStatus() + ")");
		if (!employee.getTenure().equalsIgnoreCase(emp.getTenure()))
			listOfChanges.add("Tenure");
		if (!employee.getDoj().equalsIgnoreCase(emp.getDoj()))
			listOfChanges.add("Date of Joining");
		if (!employee.getPhone().equalsIgnoreCase(emp.getPhone()))
			listOfChanges.add("Phone");
		if (!employee.getEmail().equalsIgnoreCase(emp.getEmail()))
			listOfChanges.add("E-mail");
		if (!employee.getWtr().equalsIgnoreCase(emp.getWtr()))
			listOfChanges.add("Willing to Relocate(" + emp.getWtr() + " to " + employee.getWtr() + ")");
		if (!employee.getWl().equalsIgnoreCase(emp.getWl()))
			listOfChanges.add("Work Location");
		if (!employee.getCl().equalsIgnoreCase(emp.getCl()))
			listOfChanges.add("Current Location");
		if (!employee.getHl().equalsIgnoreCase(emp.getHl()))
			listOfChanges.add("Home Location");
		changes += listOfChanges.toString().replace("[", "").replace("]", "");
		return changes;
	}

	public String checkEmpVerticalHistory(String emp, Vertical vertical) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		if (vertical.getSpoc() == null)
			vertical.setSpoc(new Spoc());
		String changes = "";
		ArrayList<String> listOfChanges = new ArrayList<String>();
		Vertical vert = new Vertical();

		fetchOldVertDetails(emp, vert);
		if (vert.getVertical().getName() == null
				|| !vert.getVertical().getName().equalsIgnoreCase(vertical.getVertical().getName()))
			listOfChanges
					.add("Vertical(" + vert.getVertical().getName() + " to " + vertical.getVertical().getName() + ")");
		if (vert.getSpoc().getName() == null
				|| !vert.getSpoc().getName().equalsIgnoreCase(vertical.getSpoc().getName()))
			listOfChanges
					.add("Vertical SPOC(" + vert.getSpoc().getName() + " to " + vertical.getSpoc().getName() + ")");
		changes += listOfChanges.toString().replace("[", "").replace("]", "");
		return changes;
	}

	public String checkEmpAccountHistory(String emp, Account account) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		if (account.getSpoc() == null)
			account.setSpoc(new Spoc());
		String changes = "";
		ArrayList<String> listOfChanges = new ArrayList<String>();
		Account acc = new Account();

		fetchOldAccDetails(emp, acc);
		if (acc.getAccount().getName() == null
				|| !acc.getAccount().getName().equalsIgnoreCase(account.getAccount().getName()))
			listOfChanges.add("Account(" + acc.getAccount().getName() + " to " + account.getAccount().getName() + ")");
		if (acc.getSpoc().getName() == null || !acc.getSpoc().getName().equalsIgnoreCase(account.getSpoc().getName()))
			listOfChanges.add("Account SPOC(" + acc.getSpoc().getName() + " to " + account.getSpoc().getName() + ")");
		changes += listOfChanges.toString().replace("[", "").replace("]", "");
		return changes;
	}

	private void scrubDate(String tenure, Employee employee) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		String[] parts = tenure.split("T");
		employee.setTenure(parts[0]);

	}

	private void scrubDOJDate(String doj, Employee employee) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		String[] parts = doj.split("T");
		employee.setDoj(parts[0]);

	}

	public boolean deleteEmployee(String empId) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		boolean result = true;
		try {
			// ps = con.prepareStatement(Queries.DELETEEMPHISTORY);
			// ps = con.prepareStatement(Queries.DELETEEMPVERTICAL);
			// ps = con.prepareStatement(Queries.DELETEEMPACCOUNT);
			// ps = con.prepareStatement(Queries.DELETEEMPCOMMENTS);
			// ps = con.prepareStatement(Queries.DELETEEMPSKILLS);
			// ps = con.prepareStatement(Queries.DELETEEMPTRAINING);
			// ps = con.prepareStatement(Queries.DELETEEMPLOYEE);

			emphash.remove(empId);

		} catch (Exception e1) {
			System.out.println("Exception");
			e1.printStackTrace();
			result = false;
		}
		return result;
	}

	public boolean deleteSkill(String key, String type) {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		Utilities.LOG.info("Dummy Event");
		boolean result = true;
		return result;
	}

	private void setEmpDetails(ArrayList<Employee> employees) throws SQLException {
		Utilities.LOG.info("Entering the Method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Employee e = new Employee();

		e.setEmpId("empId");
		e.setName("EMP_NAME");
		e.setStatus("status");
		e.setPhone("phone");
		e.setEmail("email");
		e.setWl("wl");
		e.setHl("hl");
		e.setCl("cl");
		e.setWtr("wtr");

		employees.add(e);
	}

*/}
