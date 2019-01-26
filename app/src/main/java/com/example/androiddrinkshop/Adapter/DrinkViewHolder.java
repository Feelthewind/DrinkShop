package com.example.androiddrinkshop.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androiddrinkshop.Interface.IItemClickListener;
import com.example.androiddrinkshop.R;

import org.w3c.dom.Text;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img_product;
    TextView txt_drink_name, txt_price;

    IItemClickListener itemClickListener;

    public void setItemClickListener(IItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DrinkViewHolder(@NonNull View itemView) {
        super(itemView);

        img_product = (ImageView)itemView.findViewById(R.id.image_product);
        txt_drink_name = (TextView)itemView.findViewById(R.id.txt_drink_name);
        txt_price = (TextView)itemView.findViewById(R.id.txt_price);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v);
    }
}
