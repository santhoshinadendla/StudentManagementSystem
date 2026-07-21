<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
<form action="UpdateStudentServlet"method="post">
ID:<input type="text" name="id">
<br>

NAME:<input type="text" name="name">
<br>

AGE:<input type ="text" name="age">
<br>

COURSE:<input type ="text" name="course">
<br>
<input type ="submit" value="Update">







</form>
</body>
</html>