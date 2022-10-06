package com.endava.fooddelivery.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.endava.fooddelivery.R;
import com.endava.fooddelivery.adapter.CategoryRecyclerViewAdapter;
import com.endava.fooddelivery.adapter.FoodRecyclerViewAdapter;
import com.endava.fooddelivery.model.Category;
import com.endava.fooddelivery.model.Food;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   private RecyclerView.Adapter categoryRecyclerViewAdapter, foodRecyclerViewAdapter;
   private RecyclerView recyclerViewCategories, recyclerViewFood;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      recyclerViewCategories = findViewById(R.id.recyclerViewCategories);
      recyclerViewFood = findViewById(R.id.recyclerViewFood);

      List<Category> categories = List.of(
            new Category("Pizza", "cat_1"),
            new Category("Burger", "cat_2"),
            new Category("Hotdog", "cat_3"),
            new Category("Drink", "cat_4"),
            new Category("Donut", "cat_5")
      );
      categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(categories);
      recyclerViewCategories.setAdapter(categoryRecyclerViewAdapter);
      recyclerViewCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

      List<Food> foods = List.of(
            new Food("Pepperoni pizza", "pizza1", "slices pepperoni, mozarella cheese, fresh oregano, ground black pepper, sauce", 9.76),
            new Food("Cheese Burger", "burger", "beef, gouda cheese, special sauce, lettuce, tomatoes", 8.79),
            new Food("Vegetable pizza", "pizza2", "olive oil, vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 8.50)
      );
      foodRecyclerViewAdapter = new FoodRecyclerViewAdapter(foods);
      recyclerViewFood.setAdapter(foodRecyclerViewAdapter);
      recyclerViewFood.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
   }
}