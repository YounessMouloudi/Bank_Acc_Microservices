package com.projects.account_service.clients;

import com.projects.account_service.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    /* hna 3ndna had methode li tatjib lina données d Customer b id dialo li ghadi nakhdoh mn account ay
    hna tan3ayto l server akhor w li howa CustomerService => had la metho tansta3mloha f findAccountByID
    donc ila ta7 had server(customer) had la methode maghatkhdamch w donc findAccountByID tahia maghatkhdamch
    w hna 3ndna mochkil alors bach n7alo had lmochkil tandiro had circuit breaker tan3tiwah le nom d server w
    la methode li ghatkhdam blasst dik la methode li makhdmatch ay findCustomerById w haka la methode d findAcc
    tatb9a khdama w n9adro nzido nconfiguiriwh ay na3tiwah ydir retry ay y3awd yseft req lserv f kol 7sec aw li
    bghiti bach ychof wach khdam */
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id,Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not Available");
        customer.setLastName("Not Available");
        customer.setEmail("Not Available");

        return customer;
    }
    default List<Customer> getAllCustomers(Exception exception) {
        return List.of();
    }
}

/* Resilience4J : (Fault Tolerance) => hadi c'est une librarie li tansta3mloha bach ntssam7o m3a les fautes li
taywa93o f servers çàd gérer les exceptions; ils contients plusieurs modéles :
- Circuit Breaker : hada b7al Disjoncteur dial doo ay howa li tansta3mloh ila ta7 lina chi server bach
                    maytiya7ch lina les autres servers li 3ndhom relation m3ah
- Rate Limiter : (Block too frequent requests) => hada tanlimitiw bih les nombres de requests l un server
                 (ou api) par sec => par ex : 5 req/sec
- Time Limiter : (set a time limit when calling remote operation)
- Retry Mechanisme : (Automaticlly retry a failed remote request) => hada mnin taykon chi echec f server howa
                     li tayb9a y3awd ysefte un request bach ychof wach khdam
- Bulkheading : (Avoid to many concurent request)
- Cache : (store results of costly remote operation)

*/