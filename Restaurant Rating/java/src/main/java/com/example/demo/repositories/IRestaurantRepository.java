package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Restaurant;

public interface IRestaurantRepository {
    
    Restaurant save(Restaurant restaurant);
    List<Restaurant> findall();
    Optional<Restaurant> findById(Long id);
    String describe(Restaurant restaurant);
    void updateOverallRating(Long rating,Restaurant restaurant);
}
