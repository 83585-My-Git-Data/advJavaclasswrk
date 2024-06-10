<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Syntax</title>
</head>
<body>
	<h1>JSP Syntax Demo</h1>
	<%!
	int count = 0;
	public void jspInit(){
	System.out.println("demo1 jspInit() called.");
	
	}
	
	public void jspDestroy() {
			System.out.println("demo1 jspDestroy() called.");
		}
	%>
	
	<%
		Date now = new Date();
		out.println("Server Time: " + now);
	%>
	
	<br/><br/>
	<% count++; %>
	<% if(count % 2 == 0) { %>
		Even Count: <%= count %>
	<% } else { %>	
		Odd Count: <%= count %>
	<% } %>
	<br/><br/>
	<%
		if(count % 2 == 0)
			out.println("Even Count: " + count);
		else
			out.println("Odd Count: " + count);
	%>
	
</body>
</html>