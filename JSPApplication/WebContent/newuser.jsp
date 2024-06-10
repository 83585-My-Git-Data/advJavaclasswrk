<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Register</title>
</head>
<body>
	<form method="post" action="loginbean.jsp">
		First Name: <input type="text" name="firstname"/> <br/><br/>
		Last Name: <input type="text" name="lastname"/> <br/><br/>
		Email: <input type="email" name="email"/> <br/><br/>
		Password: <input type="password" name="passwd"/> <br/><br/>
		DOB: <input type="date" name="dob"/> <br/><br/>
		Role: <select name="role">
				<option>Admin</option>
				<option>Voter</option>
				</select> <br/><br/>
		Status: <input type="text" name="status"/> <br/><br/>
		 
		<input type="submit" value="SignUP"/>
	</form>
</body>
</html>