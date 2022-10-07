package com.endava.fooddelivery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.endava.fooddelivery.R;
import com.endava.fooddelivery.helper.ManagementCart;
import com.endava.fooddelivery.listener.ChangeNumberItemsListener;
import com.endava.fooddelivery.model.Food;

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

   private List<Food> foods;
   private ManagementCart managementCart;
   private ChangeNumberItemsListener changeNumberItemsListener;

   public CartRecyclerViewAdapter(List<Food> foods, ManagementCart managementCart, ChangeNumberItemsListener changeNumberItemsListener) {
      this.foods = foods;
      this.managementCart = managementCart;
      this.changeNumberItemsListener = changeNumberItemsListener;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false));
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
      viewHolder.itemTitleTextView.setText(foods.get(position).getTitle());
      viewHolder.itemFeeTextView.setText(String.valueOf(foods.get(position).getFee()));
      viewHolder.numberItemTextView.setText(String.valueOf(foods.get(position).getNumberInCart()));
      viewHolder.itemTotalPriceTextView.setText(String.valueOf(Math.round(foods.get(position).getNumberInCart() * foods.get(position).getFee() * 100) / 100));

      int drawableResourceId = viewHolder.itemView.getContext().getResources().getIdentifier(foods.get(position).getPic(), "drawable", viewHolder.itemView.getContext().getPackageName());
      Glide.with(viewHolder.itemView.getContext()).load(drawableResourceId).into(viewHolder.individualItemPic);

      viewHolder.itemCartPlusButton.setOnClickListener(view -> managementCart.incrementNumberFoodItem(foods, position, () -> {
         notifyDataSetChanged();
         changeNumberItemsListener.getChanged();
      }));
      viewHolder.itemCartMinusButton.setOnClickListener(view -> managementCart.decrementNumberFoodItem(foods, position, () -> {
         notifyDataSetChanged();
         changeNumberItemsListener.getChanged();
      }));
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
      private TextView itemTitleTextView, itemFeeTextView, itemTotalPriceTextView, numberItemTextView;
      private ImageView individualItemPic, itemCartPlusButton, itemCartMinusButton;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);

         itemTitleTextView = itemView.findViewById(R.id.itemTitleTextView);
         itemFeeTextView = itemView.findViewById(R.id.itemFeeTextView);
         itemTotalPriceTextView = itemView.findViewById(R.id.itemTotalPriceTextView);
         numberItemTextView = itemView.findViewById(R.id.numberItemTextView);
         individualItemPic = itemView.findViewById(R.id.individualItemPic);
         itemCartPlusButton = itemView.findViewById(R.id.itemCartPlusButton);
         itemCartMinusButton = itemView.findViewById(R.id.itemCartMinusButton);
      }
   }
}
