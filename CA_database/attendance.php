<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['student_id']) && isset($_POST['course_id']) && isset($_POST['date']) && isset($_POST['intake'])) {
    if ($db->dbConnect()) {
        if ($db->attendance("attendance", $_POST['student_id'], $_POST['course_id'], $_POST['date'], $_POST['intake'])) {
            echo "Submitted Attendance";
        } else echo "Submit Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>