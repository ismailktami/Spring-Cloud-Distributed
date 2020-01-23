package com.example.billingservice;

import com.example.billingservice.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerService customerService,
							InventoryService inventoryService
							){
		return args ->
		{	Customer customer=customerService.findCustomerById(1L);
			System.err.println("***************************");
			System.out.println("ID = "+customer.getId());
			System.out.println("Name = "+customer.getName());
			System.err.println("***************************");
			Bill bill1=billRepository.save(new Bill(new Date(),1L,null));

			//Find product
		/*	Product p=inventoryService.findProductById(1L);
			Product p1=inventoryService.findProductById(2L);
			Product p2=inventoryService.findProductById(3L);

		*/
			PagedModel<Product> products=inventoryService.findAllProducts();

			for (Product product : products.getContent()) {
				productItemRepository.save(new ProductItem(1L,product.getPrice(),100,bill1));

			}

		};


	}
}
