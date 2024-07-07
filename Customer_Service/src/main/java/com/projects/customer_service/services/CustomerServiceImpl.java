package com.projects.customer_service.services;

import com.projects.customer_service.dtos.CustomerDTO;
import com.projects.customer_service.entities.Customer;
import com.projects.customer_service.mappers.CustomerMapper;
import com.projects.customer_service.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO customerRespDTO = customerMapper.entityToCustomerDTO(savedCustomer);

        return customerRespDTO;
    }

    @Override
    public CustomerDTO getCustomer(Long id) {

        Customer customer = customerRepository.findById(id).get();
        return customerMapper.entityToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        Customer updatedCustomer = customerRepository.save(customer);

        return customerMapper.entityToCustomerDTO(updatedCustomer);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();

        List<CustomerDTO> customerRespDTOS = customers.stream()
                .map( customer -> customerMapper.entityToCustomerDTO(customer)
                    ).collect(Collectors.toList());

        return customerRespDTOS;
    }
}
