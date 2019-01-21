package com.pel2.ecmt.service;

import org.springframework.stereotype.Service;

@Service
public class BatchProcessorService 
{/*
	
	@Autowired
	Dao dao;
	@Autowired
	EcmtHashBatch ebatch;
	@Autowired
	Utilities utilities;
	
	public boolean processBatch(String batch)
	{
		boolean result = true;
		
		boolean quoteFlag = false;
		ArrayList<String> newEmp = new ArrayList<String>();
		StringBuffer str = new StringBuffer();
//		TotalVertAcc verts = dao.getVerticalAccount();
		TotalVertAcc verts = ebatch.getVerticalAccount();
		ArrayList<Spoc> spocs;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = dateFormat.format(date);
		
		
		for (int ch = 0; ch < batch.length(); ch++)
		{
			if(ch + 1 <= batch.length())
			{
				if (batch.charAt(ch) == '\\' && batch.charAt(ch + 1) == 'n')
				{
					newEmp.add(str.toString());
					ch++;
					continue;
				}	
			}
			
			if(batch.charAt(ch) == '"')
			{
				if(quoteFlag == true)
					quoteFlag = false;
				else
					quoteFlag = true;
			}
			
			if(quoteFlag == false)
			{
				if(batch.charAt(ch) == ',')
				{
					newEmp.add(str.toString());
					str.setLength(0);
				}
				else
				{
					str.append(batch.charAt(ch));
				}
			}
			else
			{
				str.append(batch.charAt(ch));
			}
		}
		newEmp.add(str.toString());
		
		
		
		//this loop correctly splits up the end of one employee 
		//and the beginning of the next employee
		for (int i = 14; i < newEmp.size(); i += 14)
		{
			if(i + 1 == newEmp.size())
				break;
			String[] tmp = newEmp.get(i).split("\n");
			newEmp.set(i, tmp[0]);
			newEmp.add(++i, tmp[1]);
		}
		
		for (int i = 0; i < newEmp.size(); i += 15)
		{
			Employee emp = new Employee();
			emp.setEmpId(newEmp.get(i));
			emp.setName(newEmp.get(i + 1));
			//emp.setTenure(newEmp.get(i + 2));
			emp.setTenure(today);
			emp.setDoj(utilities.convertDate(newEmp.get(i + 3), "yyyy-MM-dd"));
			emp.setWtr("N/A");
			emp.setPhone(newEmp.get(i + 5));
			emp.setEmail(newEmp.get(i + 6));
			emp.setCl(newEmp.get(i + 7).replace("\"", ""));
			emp.setWl(newEmp.get(i + 8).replace("\"", ""));
			emp.setHl(newEmp.get(i + 9).replace("\"", ""));
			emp.setStatus("Bench");
			
		//	dao.insertEmployee(emp);
		// Added the procedure to load into the HashMap table	
			ebatch.insertEmployee(emp);		
			
			String vertId = null;
			for(DropdownObj v : verts.getVertDetails())
			{
				if(v.getName().equalsIgnoreCase(newEmp.get(i + 10)))
				{
					vertId = v.getId();
					break;
				}
			}
			
			Vertical vertical = new Vertical();
			Spoc spoc = new Spoc();
			DropdownObj vert = new DropdownObj();
			vert.setId(vertId);
			vert.setName(newEmp.get(i + 10));
			vertical.setEmpId(emp.getEmpId());
			vertical.setVertical(vert);
			
//			spocs = dao.getVerticalSPOC(vert.getId());
			spocs = ebatch.getVerticalSPOC(vert.getId());
			
			for(Spoc s : spocs)
			{
				if(s.getName().contains(newEmp.get(i + 11)))
				{
					spoc.setId(s.getId());
					spoc.setName(s.getName());
					break;
				}
			}
			
			vertical.setSpoc(spoc);
			
//			dao.insertEmpVertical(vertical, emp.getEmpId());
			ebatch.insertEmpVertical(vertical, emp.getEmpId());
			
			Account account = new Account();
			account.setAccount(new DropdownObj("0",""));
			account.setSpoc(new Spoc());
//			dao.insertEmpAccount(account, emp.getEmpId());
			ebatch.insertEmpAccount(account, emp.getEmpId());
			
//			dao.insertHistory(emp.getEmpId(), "Employee created");
			ebatch.insertHistory(emp.getEmpId(), "Employee created");
			
			String[] skills = newEmp.get(i + 14).split("/");
			for (int skill = 0; skill < skills.length; skill++)
			{
				Skill newSkill = new Skill();
				newSkill.setEmpId(emp.getEmpId());
				newSkill.setSkillName(skills[skill]);
				
//				dao.insertSkill(newSkill, "skill");
				ebatch.insertSkill(newSkill, "skill");
			}
		}
		return result;
	}
*/}