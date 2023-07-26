package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.RestaurantService;

public class DescribeRestaurantCommand implements ICommand{
    private final RestaurantService restaurantService;

    public DescribeRestaurantCommand(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long restaurantId = Long.parseLong( tokens.get(1));

        String describeRestaurant = restaurantService.describeRestaurant(restaurantId);
        System.out.println(describeRestaurant);
    }

    
    
}
