package com.example.customer_service;

import com.example.customer_service.entities.Customer;
import com.example.customer_service.repositories.CustomerRep;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}




	@Bean
	CommandLineRunner start(CustomerRep c, RepositoryRestConfiguration repositoryRestConfiguration){
	 return args -> {
	 	repositoryRestConfiguration.exposeIdsFor(Customer.class);
	 	c.save(new Customer("ismail","ismail@gmail.com"));
	 	c.save(new Customer("hassan","hassan@gmail.com"));
	 	c.save(new Customer("mouad","mouad@gmail.com"));
		c.findAll().forEach(System.out::println);
	 };

	}
}
