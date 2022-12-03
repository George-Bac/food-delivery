package com.endava.fooddelivery.adapter;

import android.content.Intent;
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
import com.endava.fooddelivery.activity.DetailsActivity;
import com.endava.fooddelivery.model.Category;
import com.endava.fooddelivery.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {

   private List<Food> popularFood = new ArrayList<>();

   public FoodRecyclerViewAdapter(List<Food> popularFood) {
      this.popularFood = popularFood;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular_food, parent, false));
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
      viewHolder.itemTitle.setText(popularFood.get(position).getTitle());
      viewHolder.itemFee.setText(String.valueOf(popularFood.get(position).getFee()));
      int drawableResourceId = viewHolder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(), "drawable", viewHolder.itemView.getContext().getPackageName());
      Glide.with(viewHolder.itemView.getContext()).load(drawableResourceId).into(viewHolder.itemPic);
      viewHolder.itemAddButton.setOnClickListener(view -> {
         Intent intent = new Intent(viewHolder.itemView.getContext(), DetailsActivity.class);
         intent.putExtra("food", popularFood.get(position));
         viewHolder.itemView.getContext().startActivity(intent);
      });
   }

   @Override
   public int getItemCount() {
      return popularFood.size();
   }

   public void setPopularFood(List<Food> popularFood) {
      this.popularFood = popularFood;
      notifyDataSetChanged();
   }

   public class ViewHolder extends RecyclerView.ViewHolder {
      private TextView itemTitle, itemFee, itemAddButton;
      private ImageView itemPic;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);

         itemTitle = itemView.findViewById(R.id.itemTitle);
         itemFee = itemView.findViewById(R.id.itemFee);
         itemPic = itemView.findViewById(R.id.itemPic);
         itemAddButton = itemView.findViewById(R.id.itemAddButton);
      }
   }
}
