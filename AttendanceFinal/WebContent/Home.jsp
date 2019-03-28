<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body background="image/home.jpg">
	<center>
		    <br><br>
		    <img src="image/attend.png" width="300" height="110">
    		<form action="AttendanceServlet">
    		<br><br>
			<br><br>
				<font size=5>Roll No.:</font>
					<select name="box" style="width: 80px; font-size:20px; border: 1px solid #ccc; sixe: 100px;">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
		    <br><br>
		   	<br>
	    		<font size=5>Present:</font>
				<input type="checkbox" style="zoom:1.5;" name="p" value="Present">
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<font size=5>Absent:</font>
				<input type="checkbox" style="zoom:1.5;" name="a" value="Absent">
				
				<br><br>
				<br><br>
				<center><input type="submit" style="padding: 7px 15px; font-size: 16px; text-align: center; 
				background-color: gray; color: white;" value="Insert"></center>
		</form>
		<form action="LogoutServlet">
			<input type="submit" style="padding: 7px 15px; font-size: 16px; text-align: center; 
				background-color: gray; color: white;" value="Logout">
		</form>
	</center>
</body>
</html>