package com.endava.fooddelivery.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.endava.fooddelivery.R;
import com.endava.fooddelivery.model.Food;

public class DetailsActivity extends AppCompatActivity {

   private TextView detailsTitleTextView, detailsPriceTextView, detailsDescriptionTextView, orderProductQuantityTextView, addToCartButton;
   private ImageView detailsFoodPic, minusButton, plusButton;
   private Food food;
   private Integer numberOrder = 1;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_details);

      initViews();
      getBundle();
   }

   private void initViews() {
      detailsTitleTextView = findViewById(R.id.detailsTitleTextView);
      detailsPriceTextView = findViewById(R.id.detailsPriceTextView);
      detailsDescriptionTextView = findViewById(R.id.detailsDescriptionTextView);
      orderProductQuantityTextView = findViewById(R.id.orderProductQuantityTextView);
      addToCartButton = findViewById(R.id.addToCartButton);
      detailsFoodPic = findViewById(R.id.detailsFoodPic);
      minusButton = findViewById(R.id.minusButton);
      plusButton = findViewById(R.id.plusButton);
   }

   private void getBundle() {
      food = (Food) getIntent().getSerializableExtra("food");

      int drawableResourceId = this.getResources().getIdentifier(food.getPic(), "drawable", this.getPackageName());
      Glide.with(this).load(drawableResourceId).into(detailsFoodPic);
      detailsTitleTextView.setText(food.getTitle());
      detailsPriceTextView.setText(String.format("$%s", food.getFee()));
      detailsDescriptionTextView.setText(food.getDescription());
      orderProductQuantityTextView.setText(String.valueOf(numberOrder));

      plusButton.setOnClickListener(view -> orderProductQuantityTextView.setText(String.valueOf(++numberOrder)));
      minusButton.setOnClickListener(view -> {
         if (numberOrder > 1) numberOrder--;
         orderProductQuantityTextView.setText(String.valueOf(--numberOrder));
      });
   }
}