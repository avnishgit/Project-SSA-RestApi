package com.ag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USASTATE_MASTER")
public class StateEntity {

	@Id
	@Column(name = "ID", length = 5)
	private Integer id;
	@Column(name = "STATE_ID")
	private String StateId;
	@Column(name = "STATE_NAME")
	private String stateName;
}
