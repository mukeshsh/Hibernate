package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class MobileCustomer implements Serializable {
  
	private Integer cno;
	private String cname;
	private String caddrs;
	private long mobileNo;
	private String callerTune;
	private Integer versionCount;
}
