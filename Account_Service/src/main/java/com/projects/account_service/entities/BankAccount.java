package com.projects.account_service.entities;

import com.projects.account_service.enums.AccountType;
import com.projects.account_service.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    /* hna f Customer JPA matat3rafch had class hit machi entity ay makaynch f BD w mnin taykon 3ndna chi
    instance de class ay khassk tdir la relation par ex : OneToMany,... ect mais maymkanch dirha w had class
    machi entité ay wakha dirha ghat3tik erreur alors bach n ignoriw had erreur tandiro had @Transient ay
    tangolo l jpa ignori had attribut

    w bach n3awdo dik l relation li madrnahach tandiroha b un attribut w li howa customerId */
    @Transient
    private Customer customer;
    private Long customerId;
}
