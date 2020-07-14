package com.uma.springbootgraphql.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.springbootgraphql.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("api/v1/grapgQl")
public class EmployeeController {

	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	private GraphQLService graphQLService;

	@Autowired
	public EmployeeController(GraphQLService graphQLService) {
		this.graphQLService = graphQLService;
	}

	@GetMapping()
	public String getEmployee() {
		return "uma";

	}

	@PostMapping
	public ResponseEntity<Object> getAllEmployee(@RequestBody String query) {
		logger.info("Entering getAllEmployee");
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

}
