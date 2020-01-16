package com.ag.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SSA_MASTER")
public class SSAEntity {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer ssn;
	private String fName;
	private String lName;
	private String gender;
	private Date dob;
	private String state;
	
}
