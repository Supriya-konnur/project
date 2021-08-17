package com.xworkz.vaccinationapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@NamedQueries(value = {
		@NamedQuery(name = "verifyEmail", query = "select entity.password from VaccinationEntity entity where entity.email=:eid ") })

@Table(name="vaccination_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class VaccinationEntity {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="TYPE")
	private String type;
	
	
}
