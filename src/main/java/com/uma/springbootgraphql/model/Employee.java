package com.uma.springbootgraphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private String id;
	private String name;
	private String lname;
	private String designation;
	private String joiningDate;
	private String lastWorkingDate;

}
