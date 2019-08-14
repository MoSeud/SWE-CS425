package edu.mum.cs.swe425.project.serviceImpl;


import edu.mum.cs.swe425.project.domain.User;

import edu.mum.cs.swe425.project.repository.UserRepository;
import edu.mum.cs.swe425.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllCustomers() {
        return userRepository.findAll();
    }

    @Override
    public void saveCustomer(User customer) {
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customer.setDateRegistered(customer.getDateRegistered());
        userRepository.save(customer);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }


}
