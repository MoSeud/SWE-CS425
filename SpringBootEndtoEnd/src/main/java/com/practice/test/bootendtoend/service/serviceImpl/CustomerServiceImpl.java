package com.practice.test.bootendtoend.service.serviceImpl;

import com.practice.test.bootendtoend.domain.Customer;
import com.practice.test.bootendtoend.repository.CustomerRepository;
import com.practice.test.bootendtoend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll(Sort.by("lastName").ascending());
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> searchCustomer(String searchString,Long custId) {
        return null;
      //  return customerRepository.findCustomersByFirstNameIsContainingAndLastNameContainingAndCustomerIdContainingAndOrderByCustomerId(searchString,searchString,custId);
    }
}
