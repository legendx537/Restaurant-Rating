package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.services.RestaurantService;

public class RegisterRestaurantCommand implements ICommand{
    
    private final RestaurantService restaurantService;

    public RegisterRestaurantCommand(RestaurantService restaurantService){
           this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String message= tokens.get(1);
        Restaurant registerRestaurant= restaurantService.registerRestaurant(message);
        System.out.println(registerRestaurant);
    }
}
