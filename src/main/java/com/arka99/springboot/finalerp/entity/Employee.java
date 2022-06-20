package com.arka99.springboot.finalerp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {

	// define fields

	@NotNull
	@Id
	@Column(name="ID")
	private int id;

	@NotNull
	@NotEmpty(message = "Enter your full name here")
	@Column(name="Name")
	private String name;
	@NotNull
	@NotEmpty(message = "The email should be a valid email")
	@Email
	@Column(name="email")
	private String email;

	@NotNull
	@NotEmpty(message = "Enter a valid designation")
	@Column(name="Designation")
	private String designation;
		
	// define constructors
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String email, String designation) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.designation = designation;
	}


	public Employee(String name, String email) {
		this.name = name;
		this.email = email;
	}

	// define getter/setter

		
}











