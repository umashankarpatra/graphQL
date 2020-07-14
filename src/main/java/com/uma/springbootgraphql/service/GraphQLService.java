package com.uma.springbootgraphql.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.uma.springbootgraphql.service.dataFetcher.AllEmployeeDataFetcher;
import com.uma.springbootgraphql.service.dataFetcher.EmployeeDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service

public class GraphQLService {

	private static Logger logger = LoggerFactory.getLogger(GraphQLService.class);
	private GraphQL graphQL;

	@Value("classpath:emploies.graphql")
	Resource resource;

	private AllEmployeeDataFetcher allEmployeeDataFetcher;

	private EmployeeDataFetcher employeeDataFetcher;

	@Autowired
	public GraphQLService(AllEmployeeDataFetcher allEmployeeDataFetcher, EmployeeDataFetcher employeeDataFetcher) {

		this.allEmployeeDataFetcher = allEmployeeDataFetcher;
		this.employeeDataFetcher = employeeDataFetcher;
	}
	
	  @PostConstruct
	    private void loadGraphQlFile() throws IOException {
	        logger.info("Entering loadGraphQlFile");
	     
	        //Get the graphql file
	        File file = resource.getFile();
	        //Parse SchemaF
	        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
	        RuntimeWiring runtimeWiring = buildRuntimeWiring();
	        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
	        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	    }
	    private RuntimeWiring buildRuntimeWiring() {
	        return RuntimeWiring.newRuntimeWiring()
	                .type("Query", typeWiring -> typeWiring
	                .dataFetcher("allEmployees", allEmployeeDataFetcher)
	                .dataFetcher("employee", employeeDataFetcher)).
	                 build();
	    }
	    public GraphQL getGraphQL(){
	        return graphQL;
	    }
}
