package com.example.collegeappv02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class view_booking_books extends AppCompatActivity {

    Button button;

    RecyclerView recyclerView;

    String s1[], s2[], s3[];
    int images[] = {R.drawable.book1,R.drawable.book2,R.drawable.book3,
            R.drawable.book4,R.drawable.book5,R.drawable.book6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking_books);

        button = findViewById(R.id.back);
        //when click back
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), booking_books.class);
                startActivity(intent);
                finish();
            }
        });


        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.books);
        s2 = getResources().getStringArray(R.array.description);
        s3 = getResources().getStringArray(R.array.item_book_pagesrev);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}