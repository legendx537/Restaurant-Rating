package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Review;

public interface IReviewRepository {
    String save(Review review);
    List<Review> findall(Long restaurantId);
    List<Review> findallByRange(Long restaurantId,Long low,Long high);
}
