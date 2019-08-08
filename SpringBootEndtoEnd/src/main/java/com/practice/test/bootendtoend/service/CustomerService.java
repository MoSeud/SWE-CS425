package com.practice.test.bootendtoend.service;

import com.practice.test.bootendtoend.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    public abstract List<Customer> getAllCustomers();
    public abstract Customer saveCustomer(Customer customer);
    public abstract Customer getCustomerById(Long customerId);
    public abstract void deleteCustomerById(Long customerId);
    public abstract List<Customer> searchCustomer(String searchString, Long custId);
}
