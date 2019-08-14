package edu.mum.cs.swe425.project.service;

import edu.mum.cs.swe425.project.domain.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    List<Review> getAllReviews();
    void saveReview(Review review);
}
