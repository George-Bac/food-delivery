package com.endava.fooddelivery.helper;

import android.content.Context;
import android.widget.Toast;

import com.endava.fooddelivery.model.Food;

import java.util.ArrayList;

public class ManagementCart {

   private final Context context;
   private final TinyDB tinyDB;

   public ManagementCart(Context context) {
      this.context = context;
      this.tinyDB = new TinyDB(context);
   }

   public void insertFood(Food item) {
      ArrayList<Food> foods = tinyDB.getListObject("CartList");
      boolean existsAlready = false;
      int numberOfItems = 0;
      for (int i = 0; i < foods.size(); i++) {
         if (foods.get(i).getTitle().equals(item.getTitle())) {
            existsAlready = true;
            numberOfItems = i;
            break;
         }
      }
      if (existsAlready) foods.get(numberOfItems).setNumberInCart(item.getNumberInCart());
      else foods.add(item);
      tinyDB.putListObject("CartList", foods);
      Toast.makeText(context, "Added to your cart", Toast.LENGTH_SHORT).show();
   }
}
