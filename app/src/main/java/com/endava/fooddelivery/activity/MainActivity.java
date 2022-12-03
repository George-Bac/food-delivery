package com.endava.fooddelivery.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.endava.fooddelivery.R;
import com.endava.fooddelivery.adapter.CategoryRecyclerViewAdapter;
import com.endava.fooddelivery.adapter.FoodRecyclerViewAdapter;
import com.endava.fooddelivery.model.Category;
import com.endava.fooddelivery.model.Food;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   private RecyclerView.Adapter categoryRecyclerViewAdapter, foodRecyclerViewAdapter;
   private RecyclerView recyclerViewCategories, recyclerViewFood;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      initViews();
      configureRecyclerViewAdapter(recyclerViewCategories, categoryRecyclerViewAdapter);
      configureRecyclerViewAdapter(recyclerViewFood, foodRecyclerViewAdapter);
      defineBottomNavigation();
   }

   private void initViews() {
      recyclerViewCategories = findViewById(R.id.recyclerViewCategories);
      recyclerViewFood = findViewById(R.id.recyclerViewFood);
      categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(List.of(
            new Category("Pizza", "cat_1"),
            new Category("Burger", "cat_2"),
            new Category("Hotdog", "cat_3"),
            new Category("Drink", "cat_4"),
            new Category("Donut", "cat_5")
      ));
      foodRecyclerViewAdapter = new FoodRecyclerViewAdapter(List.of(
            new Food("Pepperoni pizza", "pop_1", "slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, sauce", 9.76),
            new Food("Cheese Burger", "pop_2", "beef, gouda cheese, special sauce, lettuce, tomatoes", 8.79),
            new Food("Vegetable pizza", "pop_3", "olive oil, vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 8.50)
      ));
   }

   private void configureRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter recyclerViewAdapter) {
      recyclerView.setAdapter(recyclerViewAdapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
   }

   private void defineBottomNavigation() {
      FloatingActionButton cartButton = findViewById(R.id.cartButton);
      LinearLayout homeButton = findViewById(R.id.homeButton);
      cartButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
      homeButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
   }
}