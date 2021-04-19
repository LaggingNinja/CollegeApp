package com.example.collegeappv02;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter_Recommended extends RecyclerView.Adapter<OrderAdapter_Recommended.ExampleViewHolder> {
    private ArrayList<myrow_order_recommended> nExampleList;

    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView nImageView;
        public TextView nTextView1;
        public TextView nTextView2;
        public TextView nTextView3;
        public TextView nTextView4;
        public TextView nTextView5;


        public ExampleViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            nImageView = itemView.findViewById(R.id.recommended_image);
            nTextView1 = itemView.findViewById(R.id.recommended_name);
            nTextView2 = itemView.findViewById(R.id.recommended_rating);
            nTextView3 = itemView.findViewById(R.id.recommended_delivery_time);
            nTextView4 = itemView.findViewById(R.id.recommended_stall);
            nTextView5 = itemView.findViewById(R.id.recommended_price);

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
    public OrderAdapter_Recommended(ArrayList<myrow_order_recommended> exampleList) {
        nExampleList = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.myrow_order_recommended, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        myrow_order_recommended currentItem = nExampleList.get(position);

        holder.nImageView.setImageResource(currentItem.getImageResource());
        holder.nTextView1.setText(currentItem.getText1());
        holder.nTextView2.setText(currentItem.getText2());
        holder.nTextView3.setText(currentItem.getText3());
        holder.nTextView4.setText(currentItem.getText4());
        holder.nTextView5.setText(currentItem.getText5());


    }
    @Override
    public int getItemCount() {
        return nExampleList.size();
    }

    public void filterList2(ArrayList<myrow_order_recommended> filteredList2) {
        nExampleList = filteredList2;
        notifyDataSetChanged();
    }
}
