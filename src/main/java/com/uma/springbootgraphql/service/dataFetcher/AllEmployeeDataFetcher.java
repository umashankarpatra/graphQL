package com.uma.springbootgraphql.service.dataFetcher;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uma.springbootgraphql.model.Employee;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllEmployeeDataFetcher implements DataFetcher {

	@Override
	public List<Employee> get(DataFetchingEnvironment environment) {

		return Arrays.asList(new Employee("111", "uma", "patra", "software engineer", "12-11-2010", "12-11-2010"));
	}

}
