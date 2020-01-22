package com.example.inventory_service;

import com.example.inventory_service.entities.Product;
import com.example.inventory_service.entities.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args->{
			productRepository.save(new Product("pc458",1524));
			productRepository.save(new Product("pc457",1577));
			productRepository.save(new Product("pc411",1511));
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
