package com.uma.springbootgraphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "first_name", nullable = false)
	private String name;
	@Column(name = "last_name", nullable = false)
	private String lname;
	@Column(name = "designation", nullable = false)
	private String designation;
	@Column(name = "email_address", nullable = false)
	private String emailId;

	public static Employee of(String name, String lname, String designation, String emailId) {
		Employee employee = new Employee();
		employee.name = name;
		employee.lname = lname;
		employee.designation = designation;
		employee.emailId = emailId;
		return employee;

	}
}
