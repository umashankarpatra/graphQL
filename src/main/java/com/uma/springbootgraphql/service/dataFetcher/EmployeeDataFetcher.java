package com.uma.springbootgraphql.service.dataFetcher;

import org.springframework.stereotype.Component;

import com.uma.springbootgraphql.model.Employee;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class EmployeeDataFetcher implements DataFetcher {

	@Override
	public Employee get(DataFetchingEnvironment dataFetchingEnvironment) {
		String id = dataFetchingEnvironment.getArgument("id");
		Employee employee=getEmployee();
		return employee;
	}

	private Employee getEmployee() {
		Employee employee = new Employee("111", "uma", "patra", "software engineer", "12-11-2010", "12-11-2010");
		return employee;
	}

}
