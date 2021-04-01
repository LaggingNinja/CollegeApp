package com.example.collegeappv02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Booking extends AppCompatActivity {

    CardView CardBooks;
    CardView CardComputers;
    CardView CardRooms;
    CardView CardBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        CardBooks = findViewById(R.id.CardBooks);
        CardComputers = findViewById(R.id.CardComputers);
        CardRooms = findViewById(R.id.CardRooms);
        CardBack = findViewById(R.id.CardBack);

        //when click Books
        CardBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Borrow Books");
                Intent intent = new Intent(getApplicationContext(), booking_books.class);
                startActivity(intent);
                finish();
            }
        });

        //when click Computers
        CardComputers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Book Computers");
                Intent intent = new Intent(getApplicationContext(), booking_computers.class);
                startActivity(intent);
                finish();
            }
        });

        //when click Rooms
        CardRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Book Rooms");
                Intent intent = new Intent(getApplicationContext(), booking_rooms.class);
                startActivity(intent);
                finish();
            }
        });

        //when click Back
        CardBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Back");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


            }
    private void showToast(String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
        };
