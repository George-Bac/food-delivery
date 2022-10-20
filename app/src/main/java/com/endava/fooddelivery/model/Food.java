package com.endava.fooddelivery.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food implements Serializable {

   private String title;
   private String pic;
   private String description;
   private Double fee;
   private int numberInCart;

   public Food(String title, String pic, String description, Double fee) {
      this.title = title;
      this.pic = pic;
      this.description = description;
      this.fee = fee;
   }
}
