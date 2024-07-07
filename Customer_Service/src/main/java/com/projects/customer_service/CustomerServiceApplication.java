package com.projects.customer_service;

import com.projects.customer_service.config.GlobalConfig;
import com.projects.customer_service.entities.Customer;
import com.projects.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customers = List.of(
					Customer.builder()
							.firstName("Ali")
							.lastName("Alami")
							.email("ali@gmail.com")
							.build(),

					Customer.builder()
							.firstName("Hamza")
							.lastName("Alaoui")
							.email("hamza@gmail.com")
							.build()
			);

			customerRepository.saveAll(customers);
		};
	}


}
