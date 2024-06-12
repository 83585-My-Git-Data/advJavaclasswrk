<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method='post' action='register.jsp'>
		First Name:<input type='text' name='firstName' required/><br/><br/>
		Last Name:<input type='text' name='lastName' required/><br/><br/>
		Email:<input type='text' name='email' required/><br/><br/>
		Password:<input type='password' name='password' required/><br/><br/>
		Date Of Birth:<input type='date' name='birth' required/><br/><br/>
		<input type='submit' value='Sign Up'/>
		</form>
</body>
</html>