package com.practice.test.bootendtoend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private Long accountNumber;
    private Double balance;
    @ManyToOne
    private Customer customer;
    @OneToOne
     private AccountType accountTypes;

}
