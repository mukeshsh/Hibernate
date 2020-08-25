package com.nt.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

@Proxy(lazy=false)
@Entity
@DynamicInsert(value=true)
    //@DynamicUpdate(true)
//@Table(name="PROJECT")
public class Project implements Serializable{

	private long projId;
	private String projName;
	private Integer teamSize;
	private String company;
	private float amount;

	
	@Id
	@Column(name="PROJID", length=10)
	@Type(type="long")
	public long getProjId() {
		return projId;
	}
	public void setProjId(long projId) {
		this.projId = projId;
	}

	@Column(name="PROJNAME", length=15,unique=true, nullable=false)
	@Type(type="string")
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	@Column(name="TEAMSIZE", length=5)
	@Type(type="int")
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	
	@Column(name="COMPANY", length=20)
	@Type(type="string")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name="AMOUNT", length=20)
	@Type(type="float")
	@Transient
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	}
   
