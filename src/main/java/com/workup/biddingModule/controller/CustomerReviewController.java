package com.workup.biddingModule.controller;

import com.workup.biddingModule.model.CustomerReview;
import com.workup.biddingModule.service.CustomerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class CustomerReviewController {

    @Autowired
    private CustomerReviewService reviewService;

    @PostMapping
    public ResponseEntity<CustomerReview> createReview(@RequestBody CustomerReview review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @GetMapping
    public ResponseEntity<List<CustomerReview>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerReview> getReviewById(@PathVariable String id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sp/{spId}")
    public ResponseEntity<List<CustomerReview>> getReviewsBySpId(@PathVariable String spId) {
        return ResponseEntity.ok(reviewService.getReviewsBySpId(spId));
    }

    @GetMapping("/customer/{cId}")
    public ResponseEntity<List<CustomerReview>> getReviewsByCustomerId(@PathVariable String cId) {
        return ResponseEntity.ok(reviewService.getReviewsByCustomerId(cId));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<CustomerReview>> getReviewsByOrderId(@PathVariable String orderId) {
        return ResponseEntity.ok(reviewService.getReviewsByOrderId(orderId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
