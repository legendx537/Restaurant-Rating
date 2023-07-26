package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Review;
import com.example.demo.services.ReviewService;

public class GetReviewsFilterOrderCommand implements ICommand{
    private final ReviewService reviewService;

    public GetReviewsFilterOrderCommand(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long restaurantId = Long.parseLong( tokens.get(1));
        Long low = Long.parseLong( tokens.get(2));
        Long high = Long.parseLong( tokens.get(3));
        String order = tokens.get(4);

        List<Review> reviewListbyRange=reviewService.getReviewByOrderFilter(restaurantId, low , high,order);
        System.out.println(reviewListbyRange);
    }
}
