package edu.mum.cs.swe425.project.service;

import edu.mum.cs.swe425.project.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HairStyleService {
    List<User> getAllCustomersWithSeatNumber(Integer seatno);
}
