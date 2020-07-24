package com.uma.springbootgraphql.service.dataFetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uma.springbootgraphql.model.Employee;
import com.uma.springbootgraphql.repository.EmployeeRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class EmployeeDataFetcher implements DataFetcher {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee get(DataFetchingEnvironment dataFetchingEnvironment) {
		return getEmployee(dataFetchingEnvironment.getArgument("id"));
	}

	private Employee getEmployee(String id) {
		return this.employeeRepository.findById(Long.valueOf(id)).get();
	}

}


