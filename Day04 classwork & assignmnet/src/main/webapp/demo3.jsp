<%@page import="java.util.Random"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page Demo</title>
</head>
<body>
	<% Random r = new Random(); %>
	<%
		int num = r.nextInt(5); // generate random number between 0 to 4
		out.println("Division: 100 / " + num + " = " + (100 / num));
	%>
</body>
</html>