package com.srh.clms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Labourer {

@Entity
@Table(name = "LABOURER")
public class Labour {
	private int idLabour;
	private int WorkType;
	private String WorkDescp;
	private int DetailedInfo_idInfo;
	private String Skill;
	private int Experience;
	private double WorkPermitNo;
	private int ATTENDANCE_idAttendence;
	private int SALARY_SalaryId;

	public Labour() {
	}

	public Labour(int idLabour, int workType, String workDescp, int detailedInfo_idInfo, String skill, int experience,
			double workPermitNo, int aTTENDANCE_idAttendence, int sALARY_SalaryId) {
		super();
		this.idLabour = idLabour;
		WorkType = workType;
		WorkDescp = workDescp;
		DetailedInfo_idInfo = detailedInfo_idInfo;
		Skill = skill;
		Experience = experience;
		WorkPermitNo = workPermitNo;
		ATTENDANCE_idAttendence = aTTENDANCE_idAttendence;
		SALARY_SalaryId = sALARY_SalaryId;
	}
	@Id
	@Column(name = "idLabour")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdLabour() {
		return idLabour;
	}

	public void setIdLabour(int idLabour) {
		this.idLabour = idLabour;
	}

	public int getWorkType() {
		return WorkType;
	}

	public void setWorkType(int workType) {
		WorkType = workType;
	}

	public String getWorkDescp() {
		return WorkDescp;
	}

	public void setWorkDescp(String workDescp) {
		WorkDescp = workDescp;
	}

	public int getDetailedInfo_idInfo() {
		return DetailedInfo_idInfo;
	}

	public void setDetailedInfo_idInfo(int detailedInfo_idInfo) {
		DetailedInfo_idInfo = detailedInfo_idInfo;
	}

	public String getSkill() {
		return Skill;
	}

	public void setSkill(String skill) {
		Skill = skill;
	}

	public int getExperience() {
		return Experience;
	}

	public void setExperience(int experience) {
		Experience = experience;
	}

	public double getWorkPermitNo() {
		return WorkPermitNo;
	}

	public void setWorkPermitNo(double workPermitNo) {
		WorkPermitNo = workPermitNo;
	}

	public int getATTENDANCE_idAttendence() {
		return ATTENDANCE_idAttendence;
	}

	public void setATTENDANCE_idAttendence(int aTTENDANCE_idAttendence) {
		ATTENDANCE_idAttendence = aTTENDANCE_idAttendence;
	}

	public int getSALARY_SalaryId() {
		return SALARY_SalaryId;
	}

	public void setSALARY_SalaryId(int sALARY_SalaryId) {
		SALARY_SalaryId = sALARY_SalaryId;
	}

}
