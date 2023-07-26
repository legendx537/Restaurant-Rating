package com.example.demo.entities;


public class Review {

    // Common u can finish it today
    // Who will get u selected 
    // Answer is u urself nobody else u understand
    
    private Long id;
    private Long rating;
    private Long userId;
    private Long restaurantId;
    private String dishes;
    private String description;
    
    public Review(Long id,Long rating,Long userId,Long restaurantId,String dishes,String description){
         this.id=id;
         this.rating=rating;
         this.userId=userId;
         this.restaurantId=restaurantId;
         this.dishes=dishes;
         this.description=description;
    }

    public Review (Long rating,Long userId,Long restaurantId,String dishes,String description){
        this(null, rating, userId, restaurantId,dishes,description);
    }

    public Long getId(){
        return id;
    }

    public Long getRating(){
        return rating;
    }

    public Long getUserId(){
        return userId;
    }

    public Long getRestaurantId(){
        return restaurantId;
    }

    public String getDishes(){
        return dishes;
    }

    public String getDescription(){
        return description;
    }
    
    @Override
    public String toString(){
         return "Review [id="+ id +"]";
    }

        
    
}
