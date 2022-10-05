package com.endava.fooddelivery.model;

import java.util.Objects;

public class Category {
   
   private String title;
   private String pic;

   public Category(String title, String pic) {
      this.title = title;
      this.pic = pic;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getpic() {
      return pic;
   }

   public void setpic(String pic) {
      this.pic = pic;
   }

   @Override
   public String toString() {
      return "Category{" +
            "title='" + title + '\'' +
            ", pic='" + pic + '\'' +
            '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Category category = (Category) o;
      return title.equals(category.title) && pic.equals(category.pic);
   }

   @Override
   public int hashCode() {
      return Objects.hash(title, pic);
   }
}
