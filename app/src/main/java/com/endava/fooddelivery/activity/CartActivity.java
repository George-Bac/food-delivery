package com.endava.fooddelivery.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.endava.fooddelivery.R;
import com.endava.fooddelivery.adapter.CartRecyclerViewAdapter;
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

      initViews();
      calculateFinalPrice();

      managementCart = new ManagementCart(this);
      cartRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
      cartRecyclerViewAdapter = new CartRecyclerViewAdapter(managementCart.getCartList(), managementCart, () -> calculateFinalPrice());
      cartRecyclerView.setAdapter(cartRecyclerViewAdapter);

      emptyCartTextView.setVisibility(managementCart.getCartList().isEmpty() ? View.VISIBLE : View.GONE);
      scrollView.setVisibility(managementCart.getCartList().isEmpty() ? View.GONE : View.VISIBLE);
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

   private void calculateFinalPrice() {
      double percentTax = 0.02, delivery = 10.0, itemTotal, total;
      tax = (double) (Math.round((managementCart.getTotalPrice() * percentTax) * 100) / 100);
      itemTotal = (double) (Math.round(managementCart.getTotalPrice() * 100) / 100);
      total = (double) (Math.round((managementCart.getTotalPrice() + tax + delivery) * 100) / 100);

      itemsPriceTextView.setText(String.format("$%s", itemTotal));
      deliveryPriceTextView.setText(String.format("$%s", delivery));
      taxPriceTextView.setText(String.format("$%s", tax));
      totalPriceTextView.setText(String.format("$%s", total));
   }
}