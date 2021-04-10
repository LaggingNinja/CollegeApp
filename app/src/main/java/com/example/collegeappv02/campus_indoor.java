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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class campus_indoor extends AppCompatActivity {
    private ArrayList<myrow_indoor> mExampleList;
    private RecyclerView mRecyclerView;
    private BookingAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_indoor);

        createExampleList();
        buildRecyclerView();

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

        //image slider
        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://university.sunway.edu.my/sites/default/files/orientation2.jpg",""));
        slideModels.add(new SlideModel("https://media.thestar.com.my/Prod/B6331500-5912-4D6D-A76F-B9F5FD4C9AE3",""));
        slideModels.add(new SlideModel("https://cdn.galaxy.tf/thumb/sizeW1100/unit-media/tc-default/uploads/images/poi_photo/001/590/663/auditorium-1-wide.jpg",""));
        slideModels.add(new SlideModel("https://louisandjoselinhome.files.wordpress.com/2019/09/sunway-library-1.jpg?w=539",""));
        slideModels.add(new SlideModel("https://louisandjoselinhome.files.wordpress.com/2019/09/sunway-ecowalk_nchc.jpg?w=1024",""));
        imageSlider.setImageList(slideModels, true);

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

    }

    private void filter (String text){
        ArrayList<myrow_indoor> filteredList = new ArrayList<>();

        for (myrow_indoor item : mExampleList){
            if (item.getText1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new myrow_indoor(R.drawable.ic_meeting_room, "Academic Staffroom 1", "Offices- Academic Offices"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_meeting_room, "Academic Staffroom 1", "Offices- Academic Offices"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_service, "Admissions Office", "Services"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_art, "Art Gallery", "Amenities - Common"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_chair, "Auditorium 1", "Classrooms - Auditoriums"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_chair, "Auditorium 2", "Classrooms - Auditoriums"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_board, "Board Room", "Amenities - Meeting Rooms"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_streetview, "Boulevard", "Amenities - Common"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_service, "CAE Admin Office", "Offices - Administrative Offices"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_service, "CELS - ESAP", "Offices- Academic Offices"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_atm, "CIMB ATM", "Amenities - ATMs"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_walk, "Canopy Walk to Sunway Pyramid", "Entrances & Walkways"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_walk, "Canopy Walk to Monash University", "Entrances & Walkways"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_design, "Design Studio", "Classrooms - Studio"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_design, "DigiCap Studio", "Classrooms - Studio"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_meeting_room, "Discussion Rooms", "Amenities - Meeting Rooms"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_map, "Directorate", "Offices - Administrative Offices"));
        mExampleList.add(new myrow_indoor(R.drawable.ic_chair2, "Examination Hall", "Classrooms - Halls"));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BookingAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BookingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), campus_indoor_map.class);
                startActivity(intent);
                finish();
            }
        });

    }

}





























