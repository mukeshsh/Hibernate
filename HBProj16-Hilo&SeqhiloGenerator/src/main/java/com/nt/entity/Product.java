package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {
	
	private Integer pid;
	private String pname;
	private Float price;
	private float qty;

}
