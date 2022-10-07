package com.endava.fooddelivery.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

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

   public Food(String title, String pic, String description, Double fee, int numberInCart) {
      this.title = title;
      this.pic = pic;
      this.description = description;
      this.fee = fee;
      this.numberInCart = numberInCart;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getPic() {
      return pic;
   }

   public void setPic(String pic) {
      this.pic = pic;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Double getFee() {
      return fee;
   }

   public void setFee(Double fee) {
      this.fee = fee;
   }

   public int getNumberInCart() {
      return numberInCart;
   }

   public void setNumberInCart(int numberInCart) {
      this.numberInCart = numberInCart;
   }

   @NonNull
   @Override
   public String toString() {
      return "Food{" +
            "title='" + title + '\'' +
            ", pic='" + pic + '\'' +
            ", description='" + description + '\'' +
            ", fee=" + fee +
            ", numberInCart=" + numberInCart +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Food food = (Food) o;
      return numberInCart == food.numberInCart &&
            title.equals(food.title) &&
            pic.equals(food.pic) &&
            description.equals(food.description) &&
            fee.equals(food.fee);
   }

   @Override
   public int hashCode() {
      return Objects.hash(title, pic, description, fee, numberInCart);
   }
}
