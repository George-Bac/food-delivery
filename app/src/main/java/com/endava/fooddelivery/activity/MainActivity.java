package com.endava.fooddelivery.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.endava.fooddelivery.R;
import com.endava.fooddelivery.adapter.CategoryRecyclerViewAdapter;
import com.endava.fooddelivery.model.Category;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   private RecyclerView.Adapter categoryRecyclerViewAdapter;
   private RecyclerView recyclerViewCategories;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      recyclerViewCategories = findViewById(R.id.recyclerViewCategories);

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
   }
}