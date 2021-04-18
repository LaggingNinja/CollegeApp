package com.example.collegeappv02;

public class myrow_attendance {
    private int student_id;
    private String intake;
    private String course_id;
    private String date;

    public myrow_attendance(int student_id, String intake, String course_id, String date) {
        this.student_id = student_id;
        this.intake = intake;
        this.course_id = course_id;
        this.date = date;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getIntake() {
        return intake;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getDate() {
        return date;
    }
}
