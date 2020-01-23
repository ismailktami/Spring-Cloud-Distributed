package com.example.inventory_service;

import com.example.inventory_service.entities.Product;
import com.example.inventory_service.entities.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
		return args->{
			repositoryRestConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null,"pc458",1524));
			productRepository.save(new Product(null,"pc457",1577));
			productRepository.save(new Product(null,"pc411",1511));
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
