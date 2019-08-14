package edu.mum.cs.swe425.project.serviceImpl;

import edu.mum.cs.swe425.project.domain.User;
import edu.mum.cs.swe425.project.repository.HairStyleRepository;
import edu.mum.cs.swe425.project.repository.SeatRepository;
import edu.mum.cs.swe425.project.service.HairStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HairStyleServiceImplementation implements HairStyleService {

    @Autowired
    private HairStyleRepository hairStyleRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Override
    public List<User> getAllCustomersWithSeatNumber(Integer seatno) {
        return seatRepository.findAllBySeatIdOrderBySeatId(seatno);
    }
}
