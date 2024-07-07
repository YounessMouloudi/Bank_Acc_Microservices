package com.projects.customer_service.services;

import com.projects.customer_service.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO getCustomer(Long id);
    CustomerDTO update(CustomerDTO customerDTO);
    List<CustomerDTO> listCustomers();

}
