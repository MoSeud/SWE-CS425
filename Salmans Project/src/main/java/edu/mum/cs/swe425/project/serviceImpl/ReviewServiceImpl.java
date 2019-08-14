package edu.mum.cs.swe425.project.serviceImpl;

import edu.mum.cs.swe425.project.domain.Review;
import edu.mum.cs.swe425.project.repository.ReviewRepository;
import edu.mum.cs.swe425.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void saveReview(Review review) {
         reviewRepository.save(review);
    }
}
