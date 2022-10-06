package com.endava.fooddelivery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.endava.fooddelivery.R;
import com.endava.fooddelivery.model.Category;
import com.endava.fooddelivery.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {

   private List<Food> foods = new ArrayList<>();
   private String picUrl;

   public FoodRecyclerViewAdapter(List<Food> foods) {
      this.foods = foods;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false));
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
      viewHolder.categoryTitle.setText(foods.get(position).getTitle());
      viewHolder.categoryTitle.setText(foods.get(position).getTitle());
      picUrl = "";
      switch (position) {
         case 0: setPicUrlAndBackground(viewHolder, "cat_1", R.drawable.category_background1); break;
         case 1: setPicUrlAndBackground(viewHolder, "cat_2", R.drawable.category_background2); break;
         case 2: setPicUrlAndBackground(viewHolder, "cat_3", R.drawable.category_background3); break;
         case 3: setPicUrlAndBackground(viewHolder, "cat_4", R.drawable.category_background4); break;
         case 4: setPicUrlAndBackground(viewHolder, "cat_5", R.drawable.category_background5); break;
      }
      int drawableResourceId = viewHolder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", viewHolder.itemView.getContext().getPackageName());
      Glide.with(viewHolder.itemView.getContext()).load(drawableResourceId).into(viewHolder.categoryPic);
   }

   private void setPicUrlAndBackground(@NonNull ViewHolder viewHolder, String newPicUrl, int categoryBackground) {
      picUrl = newPicUrl;
      viewHolder.mainLayout.setBackground(ContextCompat.getDrawable(viewHolder.itemView.getContext(), categoryBackground));
   }

   @Override
   public int getItemCount() {
      return foods.size();
   }

   public void setFoods(List<Food> foods) {
      this.foods = foods;
      notifyDataSetChanged();
   }

   public class ViewHolder extends RecyclerView.ViewHolder {
      private TextView categoryTitle;
      private ImageView categoryPic;
      private ConstraintLayout mainLayout;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);

         categoryTitle = itemView.findViewById(R.id.categoryTitle);
         categoryPic = itemView.findViewById(R.id.categoryPic);
         mainLayout = itemView.findViewById(R.id.mainLayout);
      }
   }
}
