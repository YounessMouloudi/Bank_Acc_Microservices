package com.projects.customer_service.repositories;

import com.projects.customer_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource
/* hadi il permet de démarer automatique un web service Restfull qui permet de gérer Customers mais maghadich
nkhadmo biha ghadi ndiro RestController */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
