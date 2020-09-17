package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PersonInfo implements Serializable {
     
	private int pid;
	private String pname;
	private String paddrs;
	private String email;
	private Date dob;
	private Date dom;
	private Date doj;
}
