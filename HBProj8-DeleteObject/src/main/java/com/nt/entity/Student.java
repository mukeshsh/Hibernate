package com.nt.entity;

public class Student {
	private int rno;
	private String sname;
	private String course;
	private int fee;
	private int srno;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getSrno() {
		return srno;
	}
	public void setSrno(int srno) {
		this.srno = srno;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", sname=" + sname + ", course=" + course + ", fee=" + fee + ", srno=" + srno + "]";
	}

}
