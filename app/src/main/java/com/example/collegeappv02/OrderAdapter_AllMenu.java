package com.example.collegeappv02;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter_AllMenu extends RecyclerView.Adapter<OrderAdapter_AllMenu.ExampleViewHolder> {
    private ArrayList<myrow_order_allmenu> bExampleList;

    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView bImageView;
        public TextView bTextView1;
        public TextView bTextView2;
        public TextView bTextView3;
        public TextView bTextView4;
        public TextView bTextView5;
        public TextView bTextView6;


        public ExampleViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            bImageView = itemView.findViewById(R.id.all_menu_image);
            bTextView1 = itemView.findViewById(R.id.all_menu_name);
            bTextView2 = itemView.findViewById(R.id.all_menu_desc);
            bTextView3 = itemView.findViewById(R.id.all_menu_rating);
            bTextView4 = itemView.findViewById(R.id.all_menu_deliverytime);
            bTextView5 = itemView.findViewById(R.id.all_menu_stall);
            bTextView6 = itemView.findViewById(R.id.all_menu_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
    public OrderAdapter_AllMenu(ArrayList<myrow_order_allmenu> exampleList) {
        bExampleList = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.myrow_order_allmenu, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        myrow_order_allmenu currentItem = bExampleList.get(position);

        holder.bImageView.setImageResource(currentItem.getImageResource());
        holder.bTextView1.setText(currentItem.getText1());
        holder.bTextView2.setText(currentItem.getText2());
        holder.bTextView3.setText(currentItem.getText3());
        holder.bTextView4.setText(currentItem.getText4());
        holder.bTextView5.setText(currentItem.getText5());
        holder.bTextView6.setText(currentItem.getText6());


    }
    @Override
    public int getItemCount() {
        return bExampleList.size();
    }

    public void filterList3(ArrayList<myrow_order_allmenu> filteredList3) {
        bExampleList = filteredList3;
        notifyDataSetChanged();
    }
}
