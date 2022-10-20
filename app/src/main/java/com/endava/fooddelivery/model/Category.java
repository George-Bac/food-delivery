package com.endava.fooddelivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

   private String title;
   private String pic;

   public Category(String title, String pic) {
      this.title = title;
      this.pic = pic;
   }
}
