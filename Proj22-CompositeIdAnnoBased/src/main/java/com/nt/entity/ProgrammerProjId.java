package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class ProgrammerProjId implements Serializable {
	
	@Type(type="int")
	private Integer pid;
	@Type(type="int")
	private Integer projId;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	@Override
	public String toString() {
		return "ProgrammerProjId [pid=" + pid + ", projId=" + projId + "]";
	}
}
