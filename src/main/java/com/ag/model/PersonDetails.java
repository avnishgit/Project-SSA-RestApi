package com.ag.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonDetails {

	private Integer id;
	private String fName;
	private String lName;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String state;
	private Integer ssn;
	
}
