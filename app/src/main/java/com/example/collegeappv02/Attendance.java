package com.example.collegeappv02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Attendance extends AppCompatActivity {

    TextInputEditText textInputEditTextStudentID, textInputEditTextCourseID, textInputEditTextDate;
    Spinner SpinnerIntake;
    Button button, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

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
        textInputEditTextStudentID = findViewById(R.id.student_id);
        textInputEditTextCourseID = findViewById(R.id.course_id);
        textInputEditTextDate = findViewById(R.id.date);
        SpinnerIntake = findViewById(R.id.SpinnerIntake);
        submit = findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String student_id, course_id, date, intake;
                student_id = String.valueOf(textInputEditTextStudentID.getText());
                course_id = String.valueOf(textInputEditTextCourseID.getText());
                date = String.valueOf(textInputEditTextDate.getText());
                intake = String.valueOf(SpinnerIntake.getSelectedItem());

                if(!student_id.equals("") && !course_id.equals("") && !date.equals("") && !intake.equals("")) {
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[4];
                            field[0] = "student_id";
                            field[1] = "course_id";
                            field[2] = "date";
                            field[3] = "intake";
                            String[] data = new String[4];
                            data[0] = student_id;
                            data[1] = course_id;
                            data[2] = date;
                            data[3] = intake;
                            PutData putData = new PutData("http://192.168.1.112/CA_database/attendance.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Submitted Attendance")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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