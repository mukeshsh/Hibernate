package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity
public class Product implements Serializable {
	
	/*@Id
	@GenericGenerator(name="gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	*/
	/*
	@Id
	@GenericGenerator(name="gen1",strategy = "identity")
	@GeneratedValue(generator = "gen1")
	*/
	/*
	@Id
	@GenericGenerator(name="gen1",strategy = "sequence")
	@GeneratedValue(generator = "gen1")
	*/
	/*
	@Id
	@GenericGenerator(name="gen1",strategy = "sequence",parameters = @Parameter(name="sequence_name",value="pid_seq"))
	*/
	
	@Id
	@GenericGenerator(name="gen1",strategy = "seqhelo",parameters = {@Parameter(name="sequence_name",value="pid_seq"),
	                                                                                                                                        @Parameter(name="max_lo",value="5")})
	                                                                                                                                        
	@GeneratedValue(generator = "gen1")
	private int pid;
	private String pname;
	private Float price;
	private float qty;

}
