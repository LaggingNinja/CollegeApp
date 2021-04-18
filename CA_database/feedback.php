<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['student_id']) && isset($_POST['email']) && isset($_POST['name']) && isset($_POST['content'])) {
    if ($db->dbConnect()) {
        if ($db->feedback("feedback", $_POST['student_id'], $_POST['email'], $_POST['name'], $_POST['content'])) {
            echo "Submit Complete";
        } else echo "Submit Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>