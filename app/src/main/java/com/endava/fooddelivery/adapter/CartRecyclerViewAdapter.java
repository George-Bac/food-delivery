package com.endava.fooddelivery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
      return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false));
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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
      private TextView itemTitleTextView, itemFeeTextView, itemTotalPriceTextView, num;
      private ImageView itemPic, itemPlusButton, itemMinusButton;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);
      }
   }
}
