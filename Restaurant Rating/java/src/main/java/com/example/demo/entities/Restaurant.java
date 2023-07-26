package com.example.demo.entities;


public class Restaurant {
    private Long id;
    private String restaurantName;

    // Rather than constructor arguement  we can have another things to be kept 
    // track in order to get the desired result 
    // for example for over all rating we need to keep track of nimber of reviews and 
    // rating 
    private Long reviewCount;
    private Long rating;
    private Double overallRating;
    
    // Constructor parameter will be decided by the number of argument that is provided 
    // during registering anything 
    // this rule is common for all 
    public Restaurant(Long id,String restaurantName){
        this.id=id;
        this.restaurantName=restaurantName; 
    }

    public Restaurant(String restaurantName){
        this(null ,restaurantName);
    }
    public Long getRestaurantId(){
        return id;
    }
    
    public String getRestaurantName(){
        return restaurantName;
    }
     
    // setter and getters for the additional parameters defined 
    public Long getReviewCount(){
        return reviewCount;
    }

    public void setReviewCount(Long reviewCount){
       this.reviewCount = reviewCount;
    }

    public Long getRating(){
        return rating;
    }

    public void setRating(Long rating){
      this.rating= rating;
    }

    public Double getOverallRating(){
        return overallRating;
    }

    public void setOverallrating(Double overallRating){
        this.overallRating =  overallRating;
    }

    public String toString(){
        return "Restaurant [id=" + id + "]";  
    }
}
