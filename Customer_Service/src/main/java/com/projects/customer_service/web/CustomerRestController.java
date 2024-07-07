package com.projects.customer_service.web;

import com.projects.customer_service.dtos.CustomerDTO;
import com.projects.customer_service.entities.Customer;
import com.projects.customer_service.repositories.CustomerRepository;
import com.projects.customer_service.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @GetMapping("/customers")
//    public List<Customer> customers(){
//        return customerRepository.findAll();
//    }
//
//    @GetMapping("/customers/{id}")
//    public Customer getCustomer(@PathVariable Long id){
//        return customerRepository.findById(id).get();
//    }

    @GetMapping("/customers")
    public List<CustomerDTO> customers() {
        return customerService.listCustomers();
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PutMapping("/customers/{id}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO,@PathVariable Long id) {
        customerDTO.setId(id);
        return customerService.update(customerDTO);
    }

}
