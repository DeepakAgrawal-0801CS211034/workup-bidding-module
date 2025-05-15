package com.workup.biddingModule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.workup.biddingModule.model.CustomerReview;
import java.util.List;

public interface CustomerReviewRepository extends MongoRepository<CustomerReview, String> {
    List<CustomerReview> findBySpId(String spId);
    List<CustomerReview> findByCId(String cId);
    List<CustomerReview> findByOrderId(String orderId);
}
