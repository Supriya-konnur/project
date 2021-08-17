package com.xworkz.enrollapp.entity;

import java.io.Serializable;

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
		@NamedQuery(name = "verify", query = "select entity.password from StudentEnrollEntity entity where entity.email=:emailid ") })

@Table(name="enroll_details")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentEnrollEntity implements Serializable{

	@Id
	@Column(name="ENROLL_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="ENROLL_NAME")
	private String name;
	
	@Column(name="ENROLL_EMAIL")
	private String email;
	
	@Column(name="ENROLL_PASSWORD")
	private String password;
}
