package com.uma.springbootgraphql.service.dataFetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uma.springbootgraphql.model.Employee;
import com.uma.springbootgraphql.repository.EmployeeRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllEmployeeDataFetcher implements DataFetcher {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> get(DataFetchingEnvironment environment) {
		return this.employeeRepository.findAll();

	}

}
