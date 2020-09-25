package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDTO implements Serializable {
   private Integer pid;
   private String pname;
   private float price;
   private float qty;
   private String category;
}
