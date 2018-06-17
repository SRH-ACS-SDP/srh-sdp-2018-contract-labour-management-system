package com.srh.clms.entities;

import javax.persistence.*;


@Entity
@Table(name = "CONTRACTOR")
public class Contractor extends Account
{
	@Column(name="CONTRACTOR_TYPE")
	private int contType;
	public int getContType() {
		return contType;
	}

	public void setContType(int contType) {
		this.contType = contType;
	}
	@Column(name="TYPE_DESCP")
	private String typeDesc;
	@Column(name="SKILL")
	private String skill;
	@Column(name="EXPERIENCE")
	private int experience;	

	@OneToOne(mappedBy="contractor",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Work work;

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}
	@OneToOne(mappedBy="contractor",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Salary salary;

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Contractor() {
	
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}


	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}


}
