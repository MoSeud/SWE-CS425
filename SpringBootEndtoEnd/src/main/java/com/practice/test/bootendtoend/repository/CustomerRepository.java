package com.practice.test.bootendtoend.repository;

import com.practice.test.bootendtoend.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
//    List<Customer> findCustomersByFirstNameIsContainingAndLastNameContainingAndCustomerIdContainingAndOrderByCustomerId(String firstname,
//                                                                                                                        String lastname,
//                                                                                                                        Long customerid   );
}
