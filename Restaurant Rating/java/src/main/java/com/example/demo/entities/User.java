package com.example.demo.entities;

public class User {
     private final Long id;
     private final String name;
     // private List<Review> postedReviews;

     public User(Long id,String name) {
        this.id=id;
        this.name=name;
     }

     public User(String name) {
        this(null , name);
     }

     public Long getId() {
        return id;
     }

     public String getName() {
        return name;
     }
     
    // we will see about this later  
   //   public List<Review> getUserReviews() {
   //    return postedReviews;
   //   }
     public String toString() {
        return "User [id=" + id + "]";
     }

     
}
