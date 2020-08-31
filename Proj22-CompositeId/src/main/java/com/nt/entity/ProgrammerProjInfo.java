package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProgrammerProjInfo implements Serializable {
      private ProgrammerProjId id;
      private String pname;
      private String projName;
      private Integer deptNo;
	
      
}
