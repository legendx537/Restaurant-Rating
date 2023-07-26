package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepository;

public class RestaurantService {
   private final IRestaurantRepository restaurantRepository;

   public RestaurantService(IRestaurantRepository restaurantRepository){
    this.restaurantRepository = restaurantRepository;
   }
   
   public Restaurant registerRestaurant(String name){
     
    Restaurant restaurant=new Restaurant(name);

    return restaurantRepository.save(restaurant);
   }
   
   public List<Restaurant> listRestaurant(){
    return restaurantRepository.findall();
   }

   public String describeRestaurant(Long id){
      Restaurant restaurant=restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException(
         "Restaurant with restaurant id" + id +"not found"));
         
      return restaurantRepository.describe(restaurant);
   }
}
