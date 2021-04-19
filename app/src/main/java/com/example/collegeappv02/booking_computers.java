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

public class booking_computers extends AppCompatActivity {

    TextInputEditText textInputEditTextStudentID, textInputEditTextComputerID, textInputEditTextDate, textInputEditTextStartingTime, textInputEditTextEndingTime;
    Button apply, button, view;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_computers);

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

        view = findViewById(R.id.buttonAvailable);
        //when click view
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), view_booking_computers.class);
                startActivity(intent);
                finish();
            }
        });
        textInputEditTextStudentID = findViewById(R.id.booking_computers_student_id);
        textInputEditTextComputerID = findViewById(R.id.booking_computers_computer_id);
        textInputEditTextDate = findViewById(R.id.booking_computers_date);
        textInputEditTextStartingTime = findViewById(R.id.booking_computers_startingtime);
        textInputEditTextEndingTime = findViewById(R.id.booking_computers_endingtime);
        apply = findViewById(R.id.buttonApplyComputers);
        progressBar = findViewById(R.id.progress);


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String student_id, computer_id, date, startingtime, endingtime;
                student_id = String.valueOf(textInputEditTextStudentID.getText());
                computer_id = String.valueOf(textInputEditTextComputerID.getText());
                date = String.valueOf(textInputEditTextDate.getText());
                startingtime = String.valueOf(textInputEditTextStartingTime.getText());
                endingtime = String.valueOf(textInputEditTextEndingTime.getText());

                if(!student_id.equals("") && !computer_id.equals("") && !date.equals("") && !startingtime.equals("") && !endingtime.equals("")) {

                    if (computer_id.equals("1B") || computer_id.equals("2A") || computer_id.equals("3B") || computer_id.equals("4A") || computer_id.equals("6A") || computer_id.equals("6B") || computer_id.equals("7B") || computer_id.equals("8A") || computer_id.equals("9B") || computer_id.equals("1D") || computer_id.equals("2D") || computer_id.equals("3C") || computer_id.equals("4C") || computer_id.equals("4D") || computer_id.equals("5D") || computer_id.equals("6D") || computer_id.equals("9D")){
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[5];
                            field[0] = "student_id";
                            field[1] = "computer_id";
                            field[2] = "date";
                            field[3] = "startingtime";
                            field[4] = "endingtime";
                            String[] data = new String[5];
                            data[0] = student_id;
                            data[1] = computer_id;
                            data[2] = date;
                            data[3] = startingtime;
                            data[4] = endingtime;
                            PutData putData = new PutData("http://192.168.140.82/CA_database/booking_computers.php", "POST", field, data);
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
                    } else{
                        Toast.makeText(getApplicationContext(), "Unavailable Seat", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}