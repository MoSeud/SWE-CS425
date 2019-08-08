package com.practice.test.bootendtoend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private Long customerNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;


}
