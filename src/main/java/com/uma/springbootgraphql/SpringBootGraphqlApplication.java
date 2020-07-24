package com.uma.springbootgraphql;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uma.springbootgraphql.model.Employee;
import com.uma.springbootgraphql.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootGraphqlApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlApplication.class, args);
	}

	@PostConstruct
	public void initDb() {

		Employee emp = Employee.of("uma", "shankar", "SE", "uma.patra@gmail.com");
		Employee emp_one = Employee.of("rajveer", "kumar", "TL", "rajveer.singh@gmail.com");
		Employee emp_two = Employee.of("ankur", "kumar", "SSE", "ankur.siwatch@gmail.com");

		Arrays.asList(emp, emp_one, emp_two).forEach(employee -> {
			employeeRepository.save(employee);
		});

	}

}


