package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;

public class ReviewRepository implements IReviewRepository{
    private Map<Long,Review> reviewMap;
    private Long autoIncrement=1L;

    public ReviewRepository(){
        this.reviewMap = new HashMap<Long ,Review>();
    }

    @Override
    public String save(Review review) {
        // TODO Auto-generated method stub

        // Create a new Review 
        Review r=new Review(autoIncrement , review.getRating(), 
                            review.getUserId(), review.getRestaurantId(), review.getDishes(), 
                            review.getDescription());
        // We should update the over all rating also
        

        // Save in Map for future retreval                     
        reviewMap.put(autoIncrement , r); 
        
        // Increment the autoIncrement for next review to be saved 
        autoIncrement++;                   

        return "Review [id="+ r.getId() +"] added successfully for Restaurant [id="+ r.getRestaurantId()+
         "] by User [id="+ r.getUserId()+"]!";
    }

    @Override
    public List<Review> findall(Long restaurantId) {
        // TODO Auto-generated method stub

        return reviewMap.values().stream().filter( c -> c.getRestaurantId() == restaurantId).collect(Collectors.toList());
    }

    @Override
    public List<Review> findallByRange(Long restaurantId, Long low, Long high) {
        // TODO Auto-generated method stub

        return reviewMap.values().stream().filter(c -> c.getRestaurantId() == restaurantId && low <= c.getRating() && c.getRating() <= high).collect(Collectors.toList());
    }



    
}
