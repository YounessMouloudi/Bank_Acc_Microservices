package com.projects.account_service;

import com.projects.account_service.clients.CustomerRestClient;
import com.projects.account_service.entities.BankAccount;
import com.projects.account_service.enums.AccountType;
import com.projects.account_service.repositories.BankAccRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients // hadi mohima hia bach ghadi n activiw open Feign sinon maghaykhdamch CustomerRestClient
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccRepository bankAccRepository, CustomerRestClient customerRestClient) {
		return args -> {

			customerRestClient.allCustomers().forEach(c -> {

				List<BankAccount> accounts = List.of(
					BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.currency("MAD")
							.balance(40000)
							.createAt(LocalDate.now())
							.type(AccountType.CURRENT_ACC)
							.customerId(c.getId())
							.build(),

					BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.currency("MAD")
							.balance(3000)
							.createAt(LocalDate.now())
							.type(AccountType.SAVING_ACC)
							.customerId(c.getId())
							.build()
				);

				bankAccRepository.saveAll(accounts);
			});

//			List<BankAccount> accounts = List.of(
//					BankAccount.builder()
//							.accountId(UUID.randomUUID().toString())
//							.currency("MAD")
//							.balance(40000)
//							.createAt(LocalDate.now())
//							.type(AccountType.CURRENT_ACC)
//							.customerId(Long.valueOf(1))
//							.build(),
//
//					BankAccount.builder()
//							.accountId(UUID.randomUUID().toString())
//							.currency("MAD")
//							.balance(1000)
//							.createAt(LocalDate.now())
//							.type(AccountType.SAVING_ACC)
//							.customerId(Long.valueOf(1))
//							.build(),
//
//					BankAccount.builder()
//							.accountId(UUID.randomUUID().toString())
//							.currency("MAD")
//							.balance(20000)
//							.createAt(LocalDate.now())
//							.type(AccountType.CURRENT_ACC)
//							.customerId(Long.valueOf(2))
//							.build()
//			);
//			bankAccRepository.saveAll(accounts);

		};
	}

}
