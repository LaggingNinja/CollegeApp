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

public class Feedback extends AppCompatActivity {

    TextInputEditText textInputEditTextStudentID, textInputEditTextEmail, textInputEditTextName, textInputEditTextContent;
    Button button, submit;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

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
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextName = findViewById(R.id.name);
        textInputEditTextContent = findViewById(R.id.content);
        submit = findViewById(R.id.buttonSubmit);
        progressBar = findViewById(R.id.progress);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String student_id, email, name, content;
                student_id = String.valueOf(textInputEditTextStudentID.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                name = String.valueOf(textInputEditTextName.getText());
                content = String.valueOf(textInputEditTextContent.getText());

                if(!student_id.equals("") && !email.equals("") && !name.equals("") && !content.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[4];
                            field[0] = "student_id";
                            field[1] = "email";
                            field[2] = "name";
                            field[3] = "content";
                            String[] data = new String[4];
                            data[0] = student_id;
                            data[1] = email;
                            data[2] = name;
                            data[3] = content;
                            PutData putData = new PutData("http://YOUR_IP_HERE/CA_database/feedback.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("Submit Complete")){
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