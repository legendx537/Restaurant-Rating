package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;


import com.example.demo.entities.Restaurant;

public class RestaurantRepository implements IRestaurantRepository{
    
    private Map<Long,Restaurant> restaurantMap;
    private Long autoIncrement = 1L;
    
    public RestaurantRepository(){
        this.restaurantMap=new HashMap< Long , Restaurant>();
    }

    @Override
    public Restaurant save(Restaurant restaurant){
        
        // create a restaurant
        Restaurant r=new Restaurant(autoIncrement, restaurant.getRestaurantName());
        
        // save the restaurant in map for future accessing 
        restaurantMap.put(autoIncrement , r);

        //Increase the autoIncrement for the next restaurant to be saved
        autoIncrement++;

        return r;
    }

    @Override 
    public List<Restaurant> findall(){
        return restaurantMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        // TODO Auto-generated method stub
        
        // the below method will return the restaurant if present 
        // else it will return null 
        // Optional is used to avoid null pointer exception 
        return Optional.ofNullable(restaurantMap.get(id));
    }

    @Override
    public String describe(Restaurant restaurant) {
        // TODO Auto-generated method stub
        return new StringBuilder().append("Restaurant [id=").append(restaurant.getRestaurantId())
        .append(", name=").append(restaurant.getRestaurantName()).append(", rating=")
        .append(restaurant.getOverallRating()).append("]").toString();
    }

    @Override
    public void updateOverallRating(Long rating,Restaurant restaurant) {
        // TODO Auto-generated method stub
        
        // set the rating variable
        restaurant.setRating(restaurant.getRating() == null? rating :restaurant.getRating() + rating);

        // set the review count 
        restaurant.setReviewCount(restaurant.getReviewCount() == null? 1: restaurant.getReviewCount()+1);

        // update the overall rating
        Double rating1 =Double.valueOf( restaurant.getRating());
        Double reviewCount = Double.valueOf(restaurant.getReviewCount());
        Double overAllRating = rating1 / reviewCount;
        // restaurant.setOverallrating( restaurant.getOverallRating() == null? overAllRating : overAllRating);
        restaurant.setOverallrating(overAllRating);

    }
    
    
}
