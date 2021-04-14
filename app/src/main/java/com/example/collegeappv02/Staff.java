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

public class Staff extends AppCompatActivity {

    private ArrayList<myrow_staff> mExampleList;
    private RecyclerView mRecyclerView;
    private StaffAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        createExampleList();
        buildRecyclerView();

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
        ArrayList<myrow_staff> filteredList = new ArrayList<>();

        for (myrow_staff item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new myrow_staff(R.drawable.boy, "Chong Wei Shen", "A Levels | shen@imail.sunway.edu.my | 019-2273123"));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Sheila Dunne", "A Levels | dunne@imail.sunway.edu.my | 012-3456722"));
        mExampleList.add(new myrow_staff(R.drawable.boy, "Lim Zhen Horng", "A Levels | lim@imail.sunway.edu.my | 018-2345567"));
        mExampleList.add(new myrow_staff(R.drawable.boy, "Shamsul Majid", "A Levels | shamsul@imail.sunway.edu.my | 011-9987867"));
        mExampleList.add(new myrow_staff(R.drawable.boy, "Arjun Bahl", "Sunway Diploma Studies (SDS) | arjun@imail.sunway.edu.my | 012-8897878"));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Ahsan Whitley", "Sunway Diploma Studies (SDS) | ahsan@imail.sunway.edu.my | 013-3676437"));
        mExampleList.add(new myrow_staff(R.drawable.boy, "Tang Jing Guo", "Sunway Diploma Studies (SDS) | tang@imail.sunway.edu.my | 015-2345567"));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Shao Chang Ming", "Sunway Diploma Studies (SDS) | shao@imail.sunway.edu.my | 015-2345567\""));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Cai Wen Yan", "Sunway Diploma Studies (SDS) | cai@imail.sunway.edu.my | 011-8897878\""));
        mExampleList.add(new myrow_staff(R.drawable.boy, "Greg Ramsey", "AUSMAT | greg@imail.sunway.edu.my | 012-2273123\""));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Olivia Haynes", "AUSMAT | olivia@imail.sunway.edu.my | 012-2273123\""));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Alice Lowe", "AUSMAT | alice@imail.sunway.edu.my | 013-2345567\""));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Jin Wen Qian", "Directorate | jin@imail.sunway.edu.my | 011-3456722\""));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Xia Qiu Yue", "Directorate | xia@imail.sunway.edu.my | 018-2345567\""));
        mExampleList.add(new myrow_staff(R.drawable.boy, "Vijaya Dhingra", "Directorate | vijaya@imail.sunway.edu.my | 019-9987867\""));
        mExampleList.add(new myrow_staff(R.drawable.boy, "Tejas Krish", "Financial Services | tejas@imail.sunway.edu.my | 012-8897878\""));
        mExampleList.add(new myrow_staff(R.drawable.girl, "Vivek Sani", "ITS | vivek@imail.sunway.edu.my | 013-2345567\""));
        mExampleList.add(new myrow_staff(R.drawable.boy, "Bo Myung-Hee", "ITS | bo@imail.sunway.edu.my | 013-2345567\""));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new StaffAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}