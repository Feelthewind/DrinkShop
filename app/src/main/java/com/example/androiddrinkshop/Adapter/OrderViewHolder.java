package com.example.androiddrinkshop.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.androiddrinkshop.R;

public class OrderViewHolder extends RecyclerView.ViewHolder {

    public TextView txt_order_id, txt_order_price, txt_order_address, txt_order_comment, txt_order_status;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_order_address = (TextView)itemView.findViewById(R.id.txt_order_address);
        txt_order_id = (TextView)itemView.findViewById(R.id.txt_order_id);
        txt_order_price = (TextView)itemView.findViewById(R.id.txt_order_price);
        txt_order_comment = (TextView)itemView.findViewById(R.id.txt_order_comment);
        txt_order_status = (TextView)itemView.findViewById(R.id.txt_order_status);
    }
}
