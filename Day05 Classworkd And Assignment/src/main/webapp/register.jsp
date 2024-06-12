<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="nub" class="com.sunbeam.Beans.RegisterBean" />
	<jsp:setProperty name="nub" property="*" />
	<jsp:setProperty property="status" name="nub" value="0"/>
	<jsp:setProperty property="role" name="nub" value="voter"/>
	 ${nub.register()} 
	<c:choose>
		<c:when test="${nub.count == 1}">
			Registration Successful.
			<a href="index.jsp">Log In</a>
		</c:when>
		<c:otherwise>
			Registration Failed. <br/>
			<a href="newuser.jsp">Register Again</a>
		</c:otherwise>
	</c:choose>	
	
	
	</body>
</html>