package com.example.billingservice;

import com.example.billingservice.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

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
							CustomerService customerService
							){
		return args ->
		{	Customer customer=customerService.findCustomerById(1L);
			System.out.println("***************************");
			System.out.println("ID = "+customer.getId());
			System.out.println("Name = "+customer.getName());
			System.out.println("***************************");
			Bill bill1=billRepository.save(new Bill(new Date(),1L,null));
			productItemRepository.save(new ProductItem(1L,145.0,100,bill1));
			productItemRepository.save(new ProductItem(2L,1451.0,200,bill1));
			productItemRepository.save(new ProductItem(3L,147.0,550,bill1));
		};


	}
}
