package com.endava.fooddelivery.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.endava.fooddelivery.R;
import com.endava.fooddelivery.helper.ManagementCart;

public class CartActivity extends AppCompatActivity {

   private RecyclerView.Adapter cartRecyclerViewAdapter;
   private RecyclerView cartRecyclerView;
   private ManagementCart managementCart;
   private ScrollView scrollView;
   private TextView itemsPriceTextView, deliveryPriceTextView, taxPriceTextView, totalPriceTextView, emptyCartTextView;
   private Double tax;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_cart);

      managementCart = new ManagementCart(this);

      initViews();

      cartRecyclerView.setAdapter(cartRecyclerViewAdapter);
      cartRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
   }

   private void initViews() {
      cartRecyclerView = findViewById(R.id.cartRecyclerView);
      itemsPriceTextView = findViewById(R.id.itemsPriceTextView);
      deliveryPriceTextView = findViewById(R.id.deliveryPriceTextView);
      taxPriceTextView = findViewById(R.id.taxPriceTextView);
      totalPriceTextView = findViewById(R.id.totalPriceTextView);
      emptyCartTextView = findViewById(R.id.emptyCartTextView);
      scrollView = findViewById(R.id.scrollView2);
   }
}