package com.workup.biddingModule.service;

import com.workup.biddingModule.model.CustomerReview;
import com.workup.biddingModule.repository.CustomerReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerReviewService {

    @Autowired
    private CustomerReviewRepository reviewRepository;

    public CustomerReview createReview(CustomerReview review) {
        return reviewRepository.save(review);
    }

    public List<CustomerReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<CustomerReview> getReviewById(String id) {
        return reviewRepository.findById(id);
    }

    public List<CustomerReview> getReviewsBySpId(String spId) {
        return reviewRepository.findBySpId(spId);
    }

    public List<CustomerReview> getReviewsByCustomerId(String cId) {
        return reviewRepository.findByCId(cId);
    }

    public List<CustomerReview> getReviewsByOrderId(String orderId) {
        return reviewRepository.findByOrderId(orderId);
    }

    public void deleteReview(String id) {
        reviewRepository.deleteById(id);
    }
}
