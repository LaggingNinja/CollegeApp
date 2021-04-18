<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['student_id']) && isset($_POST['book_id']) && isset($_POST['borrowdate']) && isset($_POST['returndate'])) {
    if ($db->dbConnect()) {
        if ($db->booking_books("booking_books", $_POST['student_id'], $_POST['book_id'], $_POST['borrowdate'], $_POST['returndate'])) {
            echo "Apply Complete";
        } else echo "Apply Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>