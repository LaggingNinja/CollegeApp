<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function signUp($table, $fullname, $email, $username, $password)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $table . " (fullname, username, password, email) VALUES ('" . $fullname . "','" . $username . "','" . $password . "','" . $email . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function attendance($table, $student_id, $course_id, $date, $intake)
    {
        $student_id = $this->prepareData($student_id);
        $course_id = $this->prepareData($course_id);
        $date = $this->prepareData($date);
        $intake = $this->prepareData($intake);
        $this->sql =
        "INSERT INTO " . $table . " (student_id, course_id, date, intake) VALUES ('" . $student_id . "','" . $course_id . "','" . $date . "','" . $intake . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }


    function booking_books($table, $student_id, $book_id, $borrowdate, $returndate)
    {
        $student_id = $this->prepareData($student_id);
        $book_id = $this->prepareData($book_id);
        $borrowdate = $this->prepareData($borrowdate);
        $returndate = $this->prepareData($returndate);
        $this->sql =
        "INSERT INTO " . $table . " (student_id, book_id, borrowdate, returndate) VALUES ('" . $student_id . "','" . $book_id . "','" . $borrowdate . "','" . $returndate . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function booking_computers($table, $student_id, $computer_id, $date, $startingtime, $endingtime)
    {
        $student_id = $this->prepareData($student_id);
        $computer_id = $this->prepareData($computer_id);
        $date = $this->prepareData($date);
        $startingtime = $this->prepareData($startingtime);
        $endingtime = $this->prepareData($endingtime);
        $this->sql =
        "INSERT INTO " . $table . " (student_id, computer_id, date, startingtime, endingtime) VALUES ('" . $student_id . "','" . $computer_id . "','" . $date . "','" . $startingtime . "','" . $endingtime . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function booking_rooms($table, $student_id, $rooms_id, $date, $startingtime, $endingtime)
    {
        $student_id = $this->prepareData($student_id);
        $rooms_id = $this->prepareData($rooms_id);
        $date = $this->prepareData($date);
        $startingtime = $this->prepareData($startingtime);
        $endingtime = $this->prepareData($endingtime);
        $this->sql =
        "INSERT INTO " . $table . " (student_id, rooms_id, date, startingtime, endingtime) VALUES ('" . $student_id . "','" . $rooms_id . "','" . $date . "','" . $startingtime . "','" . $endingtime . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    function feedback($table, $student_id, $email, $name, $content)
    {
        $student_id = $this->prepareData($student_id);
        $email = $this->prepareData($email);
        $name = $this->prepareData($name);
        $content = $this->prepareData($content);
        $this->sql =
        "INSERT INTO " . $table . " (student_id, email, name, content) VALUES ('" . $student_id . "','" . $email . "','" . $name . "','" . $content . "')";       
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
}
?>