package com.projects.account_service.web;

import com.projects.account_service.clients.CustomerRestClient;
import com.projects.account_service.entities.BankAccount;
import com.projects.account_service.models.Customer;
import com.projects.account_service.repositories.BankAccRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class AccountRestController {
    private BankAccRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList = accountRepository.findAll();
         // hadi ila bghina n affichiw détails dial customer f lewal ay f les listes dial accounts
//        accountList.forEach(acc -> {
//            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
//        });
        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = accountRepository.findById(id).get();
        // hna ghadi namchiw njibo les données de customer mn autre microservice(CUSTOMER) b sti3mal openFeign
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());

        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
