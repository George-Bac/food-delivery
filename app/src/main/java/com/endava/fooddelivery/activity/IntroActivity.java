package com.endava.fooddelivery.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

import com.endava.fooddelivery.R;

public class IntroActivity extends AppCompatActivity {

   private ConstraintLayout startButton;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_intro);

      startButton = findViewById(R.id.startButton);
      startButton.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, MainActivity.class)));
   }
}