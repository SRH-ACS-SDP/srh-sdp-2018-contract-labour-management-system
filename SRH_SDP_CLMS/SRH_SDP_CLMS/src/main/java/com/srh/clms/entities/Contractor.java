package com.srh.clms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTRACTOR")
public class Contractor extends DetailInfo {
	private int idContractor;
	private int ContractorType;
	private String TypeDesc;
	private int DetailedInfo_idInfo;
	private String Skill;
	private int Experience;
	private int BUILDER_idBuilder;
	private int BUILDER_Contractor_idContractor;
	private int WORK_WorkId;

	public Contractor() {
	
	}

	public Contractor(int idContractor, int contractorType, String typeDesc, int detailedInfo_idInfo, String skill,
			int experience, int bUILDER_idBuilder, int bUILDER_Contractor_idContractor, int wORK_WorkId) {
		super();
		this.idContractor = idContractor;
		ContractorType = contractorType;
		TypeDesc = typeDesc;
		DetailedInfo_idInfo = detailedInfo_idInfo;
		Skill = skill;
		Experience = experience;
		BUILDER_idBuilder = bUILDER_idBuilder;
		BUILDER_Contractor_idContractor = bUILDER_Contractor_idContractor;
		WORK_WorkId = wORK_WorkId;
	}
	@Id
	@Column(name = "idContractor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdContractor() {
		return idContractor;
	}

	public void setIdContractor(int idContractor) {
		this.idContractor = idContractor;
	}

	public int getContractorType() {
		return ContractorType;
	}

	public void setContractorType(int contractorType) {
		ContractorType = contractorType;
	}

	public String getTypeDesc() {
		return TypeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		TypeDesc = typeDesc;
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

	public int getBUILDER_idBuilder() {
		return BUILDER_idBuilder;
	}

	public void setBUILDER_idBuilder(int bUILDER_idBuilder) {
		BUILDER_idBuilder = bUILDER_idBuilder;
	}

	public int getBUILDER_Contractor_idContractor() {
		return BUILDER_Contractor_idContractor;
	}

	public void setBUILDER_Contractor_idContractor(int bUILDER_Contractor_idContractor) {
		BUILDER_Contractor_idContractor = bUILDER_Contractor_idContractor;
	}

	public int getWORK_WorkId() {
		return WORK_WorkId;
	}

	public void setWORK_WorkId(int wORK_WorkId) {
		WORK_WorkId = wORK_WorkId;
	}

}

