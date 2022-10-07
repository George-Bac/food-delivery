package com.endava.fooddelivery.helper;

import android.content.Context;
import android.widget.Toast;

import com.endava.fooddelivery.listener.ChangeNumberItemsListener;
import com.endava.fooddelivery.model.Food;

import java.util.List;

public class ManagementCart {

   private final Context context;
   private final TinyDB tinyDB;

   public ManagementCart(Context context) {
      this.context = context;
      this.tinyDB = new TinyDB(context);
   }

   public List<Food> getCartList() {
      return tinyDB.getListObject("CartList");
   }

   public void insertFood(Food item) {
      List<Food> foods = getCartList();
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

   public void incrementNumberFoodItem(List<Food> foods, int position, ChangeNumberItemsListener changeNumberItemsListener) {
      foods.get(position).setNumberInCart(foods.get(position).getNumberInCart() + 1);
      tinyDB.putListObject("CartList", foods);
      changeNumberItemsListener.getChanged();
   }

   public void decrementNumberFoodItem(List<Food> foods, int position, ChangeNumberItemsListener changeNumberItemsListener) {
      if (foods.get(position).getNumberInCart() == 1) {
         foods.remove(position);
      } else {
         foods.get(position).setNumberInCart(foods.get(position).getNumberInCart() - 1);
      }
      tinyDB.putListObject("CartList", foods);
      changeNumberItemsListener.getChanged();
   }
   
   public Double getTotalPrice() {
      List<Food> foods = getCartList();
      Double price = 0.0;
      for(Food food : foods) {
         price += food.getFee() * food.getNumberInCart();
      }
      return price;
   }
}
