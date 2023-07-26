package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.constants.ReviewOrder;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.entities.User;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.IUserRepository;

public class ReviewService {
      private final IReviewRepository reviewRepository;
      private final IRestaurantRepository restaurantRepository;
      private final IUserRepository userRepository;
      
      public ReviewService(IReviewRepository reviewRepository,IRestaurantRepository restaurantRepository
                           ,IUserRepository userRepository){
        this.reviewRepository = reviewRepository;
        this.restaurantRepository =restaurantRepository;
        this.userRepository= userRepository;
      }

      public String addRating(Long rating,Long userId,Long restaurantId){
         Restaurant restaurant=restaurantRepository.findById(restaurantId).orElseThrow(
             () -> new RuntimeException("Restaurant does not exist so u can not give review"));

          User user=userRepository.findById(userId).orElseThrow(() ->new RuntimeException(
            "User does not exist so u can not give Review"
          ));   

          // we should also upate the overall rating of the restaurant
          restaurantRepository.updateOverallRating(rating, restaurant);
          
          Review review=new Review( rating , userId ,restaurantId , "" , "");
          
          return reviewRepository.save(review);
      }

      public String addReview(Long rating,Long userId,Long restaurantId,String dishes,String description){
            Restaurant restaurant=restaurantRepository.findById(restaurantId).orElseThrow(
                  () -> new RuntimeException("Restaurant does not exist so u can not give review"));
     
               User user=userRepository.findById(userId).orElseThrow(() ->new RuntimeException(
                 "User does not exist so u can not give Review"
               ));   

               // we should also upate the overall rating of the restaurant
               restaurantRepository.updateOverallRating(rating, restaurant);
               
               Review review=new Review( rating , userId ,restaurantId , dishes , description );
            
               return reviewRepository.save(review);
      }

      public List<Review> getReviewByOrder(Long restaurantId,String order){
            Restaurant restaurant=restaurantRepository.findById(restaurantId).orElseThrow(
                  () -> new RuntimeException("Restaurant does not exist so u can not get Reviews!"));
            
            // Remember the the following part that 
            // To convert from long wrapper class to int primitive type 
            // we have to use .intValue() 
            // This concept is called
            // // 1. Unboxing through method invocation 
            if(ReviewOrder.RATING_ASC.toString().equals(order) )
             return reviewRepository.findall(restaurantId).stream().sorted(
                    (c1 ,c2) -> c1.getRating().intValue() - c2.getRating().intValue()).collect(Collectors.toList());
            
            return reviewRepository.findall(restaurantId).stream().sorted(
                        (c1 ,c2) -> c2.getRating().intValue() - c1.getRating().intValue()).collect(Collectors.toList());
      }
      

      //One Last is remaing 
      // We will finish it after dinner 
      public List<Review> getReviewByOrderFilter(Long restaurantId,Long low,Long high,String order){
           
            if(ReviewOrder.RATING_ASC.toString().equals(order) )
            return reviewRepository.findallByRange(restaurantId , low , high).stream().sorted(
                   (c1 ,c2) -> c1.getRating().intValue() - c2.getRating().intValue()).collect(Collectors.toList());
           
           return reviewRepository.findallByRange(restaurantId , low , high).stream().sorted(
                       (c1 ,c2) -> c2.getRating().intValue() - c1.getRating().intValue()).collect(Collectors.toList());
      }

}
