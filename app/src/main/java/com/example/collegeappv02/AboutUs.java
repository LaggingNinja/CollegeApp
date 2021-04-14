package com.example.collegeappv02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    ImageButton button;
    TextView web,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        button = findViewById(R.id.back);
        //when click back
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), More.class);
                startActivity(intent);
                finish();
            }
        });

        web = findViewById(R.id.web);
        //when click web
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.sunway.edu.my"));
                startActivity(browserIntent);
                finish();
            }
        });

        address = findViewById(R.id.address);
        //when click address
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GoogleMaps.class);
                startActivity(intent);
                finish();
            }
        });
    }
}