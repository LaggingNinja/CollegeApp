<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['student_id']) && isset($_POST['rooms_id']) && isset($_POST['date']) && isset($_POST['startingtime']) && isset($_POST['endingtime'])) {
    if ($db->dbConnect()) {
        if ($db->booking_rooms("booking_rooms", $_POST['student_id'], $_POST['rooms_id'], $_POST['date'], $_POST['startingtime'], $_POST['endingtime'])) {
            echo "Apply Complete";
        } else echo "Apply Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>