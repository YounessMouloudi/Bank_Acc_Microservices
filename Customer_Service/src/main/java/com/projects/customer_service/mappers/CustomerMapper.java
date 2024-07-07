package com.projects.customer_service.mappers;

import com.projects.customer_service.dtos.CustomerDTO;
import com.projects.customer_service.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO entityToCustomerDTO(Customer entity);
    Customer customerDtoToCustomer(CustomerDTO customerDTO);

}
