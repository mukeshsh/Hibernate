package com.nt.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "BANK_ACCOUNT1")
public class BankAccount implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type="long")
	private Long accNo;
	
	@Column(length=20)
	@Type(type="string")
	private String holderName;
	
	@Column(length=20)
	@Type(type="double")
	private Double balance;
	
	@Column(length=10)
	@Type(type="string")
	private String type;
	
	@CreationTimestamp
	private LocalDateTime openingDate;
	
	@UpdateTimestamp
	private Timestamp lastUpdated; 
}
