package com.example.livewallpaper.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livewallpaper.Interface.ItemClickListner;
import com.example.livewallpaper.R;

public class CatagoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView category_Name;
    public ImageView background_Image;
    ItemClickListner itemClickListner;

    public ItemClickListner getItemClickListner() {
        return itemClickListner;
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    public CatagoryViewHolder(@NonNull View itemView) {
        super(itemView);
        background_Image = itemView.findViewById(R.id.image);
        category_Name = itemView.findViewById(R.id.name);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListner.onClick(v,getAdapterPosition());
    }
}
