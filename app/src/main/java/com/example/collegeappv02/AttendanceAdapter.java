package com.example.collegeappv02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<myrow_attendance> attendanceList;

    //getting the context and product list with constructor
    public AttendanceAdapter(Context mCtx, List<myrow_attendance> attendanceList) {
        this.mCtx = mCtx;
        this.attendanceList = attendanceList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.myrow_attendance, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        myrow_attendance myrow_attendance = attendanceList.get(position);

        //binding the data with the viewholder views
        holder.textViewStudentID.setText(String.valueOf(myrow_attendance.getStudent_id()));
        holder.textViewIntake.setText(String.valueOf(myrow_attendance.getIntake()));
        holder.textViewCourseID.setText(String.valueOf(myrow_attendance.getCourse_id()));
        holder.textViewDate.setText(String.valueOf(myrow_attendance.getDate()));

    }


    @Override
    public int getItemCount() {
        return attendanceList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewStudentID, textViewIntake, textViewCourseID, textViewDate;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewStudentID = itemView.findViewById(R.id.textViewStudentID);
            textViewIntake = itemView.findViewById(R.id.textViewIntake);
            textViewCourseID = itemView.findViewById(R.id.textViewCourseID);
            textViewDate = itemView.findViewById(R.id.textViewDate);

        }
    }
}
