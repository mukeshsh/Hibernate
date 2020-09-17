package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "MobileCustomer1")
public class MobileCustomer implements Serializable {
  
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cno;
	
	@Column(length = 20,unique = true)
	@Type(type="string")
	private String cname;
	
	@Column(length = 20)
	@Type(type="string")
	private String caddrs;
	
	@Column(length = 12,unique =true)
	private long mobileNo;
	
	@Column(length = 30)
	@Type(type="string")
	private String callerTune;
	
	@Version
	@Type(type="int")
	private int versionCount;
}
