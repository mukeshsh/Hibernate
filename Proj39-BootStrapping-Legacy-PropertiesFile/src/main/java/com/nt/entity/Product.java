package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Entity
public class Product implements Serializable {
	
	/* 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	*/
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	*/
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	*/
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	*/
	/*
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "jpa_seq_pid",initialValue = 10,allocationSize = 1000)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	*/
	/*
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "jpa_seq_pid")
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	*/
	
	@Id
	@TableGenerator(name="gen1",pkColumnName = "id_col",valueColumnName = "id_val",pkColumnValue = "pid",table = "id_tab",initialValue = 10,allocationSize = 10)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.TABLE)
	
	
	private int pid;
	private String pname;
	private Float price;
	private float qty;

}
