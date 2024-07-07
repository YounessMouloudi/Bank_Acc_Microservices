package com.projects.customer_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/* hna masta3malnach @Data hit galik tatjib bzf d les methodes w ta t9dar tkhla9 lin chi conflit m3a JPA
dakchi 3lach mn l2ahssan njibo des autres annotations 7na kona tandiro @Data 3la wed getter et setters et
toString mais db ghanjibohom ghi mn lombok b les annotations dialhom */
@Entity @Getter @Setter @ToString @Builder @AllArgsConstructor @NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
