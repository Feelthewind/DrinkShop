package com.example.androiddrinkshop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androiddrinkshop.Interface.IItemClickListener;
import com.example.androiddrinkshop.Model.Order;
import com.example.androiddrinkshop.OrderDetail;
import com.example.androiddrinkshop.R;
import com.example.androiddrinkshop.Utils.Common;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {

    Context context;
    List<Order> orderList;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.order_layout, viewGroup, false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, final int i) {
        holder.txt_order_id.setText(new StringBuilder("#").append(orderList.get(i).getOrderId()));
        holder.txt_order_price.setText(new StringBuilder("$").append(orderList.get(i).getOrderPrice()));
        holder.txt_order_address.setText(orderList.get(i).getOrderAddress());
        holder.txt_order_comment.setText(orderList.get(i).getOrderComment());
        holder.txt_order_status.setText(new StringBuilder("Order Status: ").append(Common.convertCodeToStatus(orderList.get(i).getOrderStatus())));

        holder.setItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View v) {
                Common.currentOrder = orderList.get(i);
                context.startActivity(new Intent(context, OrderDetail.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
