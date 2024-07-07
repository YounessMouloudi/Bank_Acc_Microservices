package com.projects.customer_service.dtos;

import jakarta.persistence.Entity;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
