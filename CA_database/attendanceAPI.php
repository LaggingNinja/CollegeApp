<?php 
 
 define('DB_HOST', 'localhost');
 define('DB_USER', 'root');
 define('DB_PASS', '');
 define('DB_NAME', 'CA_database');

 $conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
 
 if (mysqli_connect_errno()) {
 echo "Failed to connect to MySQL: " . mysqli_connect_error();
 die();
 }
 
 $stmt = $conn->prepare("SELECT student_id, course_id, date, intake FROM attendance;");
 
 //executing the query 
 $stmt->execute();
 
 //binding results to the query 
 $stmt->bind_result($student_id, $course_id, $date, $intake);
 
 $products = array(); 
 
 //traversing through all the result 
 while($stmt->fetch()){
 $temp = array();
 $temp['student_id'] = $student_id; 
 $temp['course_id'] = $course_id; 
 $temp['date'] = $date; 
 $temp['intake'] = $intake;  
 array_push($products, $temp);
 }
 
 //displaying the result in json format 
 echo json_encode($products);