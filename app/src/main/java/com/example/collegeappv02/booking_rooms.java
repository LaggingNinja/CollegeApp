package com.example.collegeappv02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class booking_rooms extends AppCompatActivity {

    TextInputEditText textInputEditTextStudentID, textInputEditTextRoomID, textInputEditTextDate, textInputEditTextStartingTime, textInputEditTextEndingTime;
    Button apply,button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_rooms);

        button = findViewById(R.id.back);
        //when click back
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Booking.class);
                startActivity(intent);
                finish();
            }
        });

        textInputEditTextStudentID = findViewById(R.id.booking_rooms_student_id);
        textInputEditTextRoomID = findViewById(R.id.booking_rooms_room_id);
        textInputEditTextDate = findViewById(R.id.booking_rooms_date);
        textInputEditTextStartingTime = findViewById(R.id.booking_rooms_startingtime);
        textInputEditTextEndingTime = findViewById(R.id.booking_rooms_endingtime);
        apply = findViewById(R.id.buttonApplyRooms);
        progressBar = findViewById(R.id.progress);


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String student_id, rooms_id, date, startingtime, endingtime;
                student_id = String.valueOf(textInputEditTextStudentID.getText());
                rooms_id = String.valueOf(textInputEditTextRoomID.getText());
                date = String.valueOf(textInputEditTextDate.getText());
                startingtime = String.valueOf(textInputEditTextStartingTime.getText());
                endingtime = String.valueOf(textInputEditTextEndingTime.getText());

                if(!student_id.equals("") && !rooms_id.equals("") && !date.equals("") && !startingtime.equals("") && !endingtime.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[5];
                            field[0] = "student_id";
                            field[1] = "rooms_id";
                            field[2] = "date";
                            field[3] = "startingtime";
                            field[4] = "endingtime";
                            String[] data = new String[5];
                            data[0] = student_id;
                            data[1] = rooms_id;
                            data[2] = date;
                            data[3] = startingtime;
                            data[4] = endingtime;
                            PutData putData = new PutData("http://192.168.1.111/CA_database/booking_rooms.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Apply Complete")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Booking.class);
                                        startActivity(intent);
                                        finish();

                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}