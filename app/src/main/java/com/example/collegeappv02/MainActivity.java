package com.example.collegeappv02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    CardView CardAttendance;
    CardView CardBooking;
    CardView CardOrder;
    CardView CardEwallet;
    CardView CardCampus;
    CardView CardFeedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardAttendance = findViewById(R.id.CardAttendance);
        CardBooking = findViewById(R.id.CardBooking);
        CardOrder = findViewById(R.id.CardOrder);
        CardEwallet = findViewById(R.id.CardEwallet);
        CardCampus = findViewById(R.id.CardCampus);
        CardFeedback = findViewById(R.id.CardFeedback);

        //when click Take Attendance
        CardAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Take Attendance");
                Intent intent = new Intent(getApplicationContext(), Attendance.class);
                startActivity(intent);
                finish();
            }
        });

        //when click Booking System
        CardBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Booking System");
                Intent intent = new Intent(getApplicationContext(), Booking.class);
                startActivity(intent);
                finish();
            }
        });

        //when click Order Food
        CardOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Order Food");
                Intent intent = new Intent(getApplicationContext(), Order.class);
                startActivity(intent);
                finish();
            }
        });

        //when click E-wallet
        CardEwallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("E-Wallet");
                Intent intent = new Intent(getApplicationContext(), Ewallet.class);
                startActivity(intent);
                finish();
            }
        });

        //when click Campus
        CardCampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Campus Map");
                Intent intent = new Intent(getApplicationContext(), Campus.class);
                startActivity(intent);
                finish();
            }
        });

        //when click Feedback
        CardFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Feedback");
                Intent intent = new Intent(getApplicationContext(), Feedback.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private void showToast(String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}