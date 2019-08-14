package edu.mum.cs.swe425.project.service;


import edu.mum.cs.swe425.project.domain.Review;
import edu.mum.cs.swe425.project.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     List<User> getAllCustomers();
    void saveCustomer(User customer);
    User findByEmail(String email);


}
