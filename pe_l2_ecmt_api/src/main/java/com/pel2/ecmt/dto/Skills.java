package com.pel2.ecmt.dto;

public class Skills 
{
	private String skillId;
	private String skillType;
	private String skillName;
	private boolean isSyntelTrained;
	
	
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String getSkillType() {
		return skillType;
	}
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public boolean isSyntelTrained() {
		return isSyntelTrained;
	}
	public void setSyntelTrained(boolean isSyntelTrained) {
		this.isSyntelTrained = isSyntelTrained;
	}
	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skillType=" + skillType + ", skillName=" + skillName
				+ ", isSyntelTrained=" + isSyntelTrained + "]";
	}
	
	
}

	