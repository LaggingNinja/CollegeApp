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

public class booking_books extends AppCompatActivity {

    TextInputEditText textInputEditTextStudentID, textInputEditTextBookID, textInputEditTextBorrowDate, textInputEditTextReturnDate;
    Button button, apply, view;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_books);

        button = findViewById(R.id.back);
        view = findViewById(R.id.buttonView);

        //when click back
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Booking.class);
                startActivity(intent);
                finish();
            }
        });

        //when click view
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), view_booking_books.class);
                startActivity(intent);
                finish();
            }
        });
        textInputEditTextStudentID = findViewById(R.id.booking_books_student_id);
        textInputEditTextBookID = findViewById(R.id.booking_books_book_id);
        textInputEditTextBorrowDate = findViewById(R.id.booking_books_borrowdate);
        textInputEditTextReturnDate = findViewById(R.id.booking_books_returndate);
        apply = findViewById(R.id.buttonApplyBooks);
        progressBar = findViewById(R.id.progress);


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String student_id, book_id, borrowdate, returndate;
                student_id = String.valueOf(textInputEditTextStudentID.getText());
                book_id = String.valueOf(textInputEditTextBookID.getText());
                borrowdate = String.valueOf(textInputEditTextBorrowDate.getText());
                returndate = String.valueOf(textInputEditTextReturnDate.getText());

                if (!student_id.equals("") && !book_id.equals("") && !borrowdate.equals("") && !returndate.equals("")) {

                    if (book_id.equals("AAM1") || book_id.equals("TGG1") || book_id.equals("TNDB1") || book_id.equals("TFIOS1") || book_id.equals("TGG2") || book_id.equals("TMM1")){
                        progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[4];
                            field[0] = "student_id";
                            field[1] = "book_id";
                            field[2] = "borrowdate";
                            field[3] = "returndate";
                            String[] data = new String[4];
                            data[0] = student_id;
                            data[1] = book_id;
                            data[2] = borrowdate;
                            data[3] = returndate;
                            PutData putData = new PutData("http://192.168.140.82/CA_database/booking_books.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Apply Complete")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Booking.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                        }
                    });
                    } else{
                        Toast.makeText(getApplicationContext(), "Unavailable Book ID", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}