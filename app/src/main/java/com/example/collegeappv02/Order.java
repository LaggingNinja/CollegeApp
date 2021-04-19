package com.example.collegeappv02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private ArrayList<myrow_order_popular> mExampleList;
    private RecyclerView mRecyclerView;
    private OrderAdapter_Popular mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ImageButton button;

    private ArrayList<myrow_order_recommended> nExampleList;
    private RecyclerView nRecyclerView;
    private OrderAdapter_Recommended nAdapter;
    private RecyclerView.LayoutManager nLayoutManager;

    private ArrayList<myrow_order_allmenu> bExampleList;
    private RecyclerView bRecyclerView;
    private OrderAdapter_AllMenu bAdapter;
    private RecyclerView.LayoutManager bLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        createExampleList();
        buildRecyclerView();


        button = findViewById(R.id.back);
        //when click back
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //search
        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });


    }



    private void filter(String text) {
        //1
        ArrayList<myrow_order_popular> filteredList = new ArrayList<>();
        for (myrow_order_popular item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);

        //2
        ArrayList<myrow_order_recommended> filteredList2 = new ArrayList<>();
        for (myrow_order_recommended item : nExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList2.add(item);
            }
        }
        nAdapter.filterList2(filteredList2);

        //3
        ArrayList<myrow_order_allmenu> filteredList3 = new ArrayList<>();
        for (myrow_order_allmenu item : bExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList3.add(item);
            }
        }
        bAdapter.filterList3(filteredList3);

    }



    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new myrow_order_popular(R.drawable.foodimg1, "Chicken Rice"));
        mExampleList.add(new myrow_order_popular(R.drawable.foodimg2, "Beef Burger"));
        mExampleList.add(new myrow_order_popular(R.drawable.foodimg3, "Pasta"));
        mExampleList.add(new myrow_order_popular(R.drawable.foodimg4, "IceCream Cake"));
        mExampleList.add(new myrow_order_popular(R.drawable.foodimg5, "Nasi Lemak"));
        mExampleList.add(new myrow_order_popular(R.drawable.foodimg6, "Prawn Mee"));
        mExampleList.add(new myrow_order_popular(R.drawable.foodimg7, "Chicken Satay"));

        nExampleList = new ArrayList<>();
        nExampleList.add(new myrow_order_recommended(R.drawable.rfood1, "Cappuccino","3.6","10 mins","Kafe Madeleine","Rm5.50"));
        nExampleList.add(new myrow_order_recommended(R.drawable.foodimg1, "Chicken Rice","4.5","10 mins","FRESCO","Rm7.70"));
        nExampleList.add(new myrow_order_recommended(R.drawable.rfood2, "Roti Canai","5","5 mins","FRESCO","Rm3.50"));
        nExampleList.add(new myrow_order_recommended(R.drawable.rfood3, "Char Kuey Teow","3.9","10 mins","FRESCO","Rm7.20"));
        nExampleList.add(new myrow_order_recommended(R.drawable.rfood4, "Tom Yam Mee","4.9","20 mins","TomYam Kitchen","Rm10.0"));
        nExampleList.add(new myrow_order_recommended(R.drawable.rfood5, "Green Tea Latte","4.3","8 mins","StarBucks","Rm15.1"));
        nExampleList.add(new myrow_order_recommended(R.drawable.rfood6, "Nasi Goreng","2.5","15 mins","TomYam Kitchen","Rm10.0"));

        bExampleList = new ArrayList<>();
        bExampleList.add(new myrow_order_allmenu(R.drawable.allimg1, "TomYam Soup","TomYam Kitchen's signature food","5","10 mins","TomYam Kitchen","Rm14.5"));
        bExampleList.add(new myrow_order_allmenu(R.drawable.allimg2, "Salmon Fish Rice","Fresh salmon from japan","4.5","20 mins","FRESCO","Rm18.9"));
        bExampleList.add(new myrow_order_allmenu(R.drawable.allimg3, "Egg Fried Rice","Uncle Roger approved fried rice","4.7","10 mins","FRESCO","Rm8.50"));
        bExampleList.add(new myrow_order_allmenu(R.drawable.allimg4, "Char Kuey Teow","Penang OG food ngl","5","10 mins","TomYam Kitchen","Rm9.50"));
        bExampleList.add(new myrow_order_allmenu(R.drawable.rfood2, "Roti Canai","Ah nek, roti canai satu !","4.1","6 mins","FRESCO","Rm3.50"));
        bExampleList.add(new myrow_order_allmenu(R.drawable.allimg6, "Tom Yam Mee","Student's all time favourite.","3.1","16 mins","TomYam Kitchen","Rm10.0"));
        bExampleList.add(new myrow_order_allmenu(R.drawable.rfood5, "Green Tea Latte","Green tea is the best tho","4.3","8 mins","StarBucks","Rm15.1"));
        bExampleList.add(new myrow_order_allmenu(R.drawable.foodimg1, "Chicken Rice","Fresh chicken all the way from ipoh","4.5","10 mins","FRESCO","Rm7.70"));
        bExampleList.add(new myrow_order_allmenu(R.drawable.rfood6, "Nasi Goreng","2.5","One of the best from TYKitchen","15 mins","TomYam Kitchen","Rm10.0"));







    }

    private void buildRecyclerView() {
        //1
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        mAdapter = new OrderAdapter_Popular(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OrderAdapter_Popular.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), ChickenRice.class);
                startActivity(intent);
                finish();
            }
        });

        //2
        nRecyclerView = findViewById(R.id.recyclerView2);
        nRecyclerView.setHasFixedSize(true);
        nLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        nAdapter = new OrderAdapter_Recommended(nExampleList);
        nRecyclerView.setLayoutManager(nLayoutManager);
        nRecyclerView.setAdapter(nAdapter);

        nAdapter.setOnItemClickListener(new OrderAdapter_Recommended.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), Cappuccino.class);
                startActivity(intent);
                finish();
            }
        });

        //3
        bRecyclerView = findViewById(R.id.recyclerView3);
        bRecyclerView.setHasFixedSize(true);
        bLayoutManager = new LinearLayoutManager(this);
        bAdapter = new OrderAdapter_AllMenu(bExampleList);
        bRecyclerView.setLayoutManager(bLayoutManager);
        bRecyclerView.setAdapter(bAdapter);

        bAdapter.setOnItemClickListener(new OrderAdapter_AllMenu.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), TomYamSoup.class);
                startActivity(intent);
                finish();
            }
        });




    }
}