package com.projects.account_service.repositories;

import com.projects.account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccRepository extends JpaRepository<BankAccount,String> {
}
