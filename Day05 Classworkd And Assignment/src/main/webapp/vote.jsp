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
	<jsp:useBean id="loginb" class="com.sunbeam.Beans.LoginBean" scope="session"/>
	<jsp:useBean id="vb" class="com.sunbeam.Beans.VoteBean" />
	<jsp:setProperty name="vb" property="candidateId" param="candidate" />
	<jsp:setProperty property="user" name="vb" value="${loginb.user}"/>
	${vb.registerVote()}
	<c:choose>
		<c:when test="${vb.count == 1}">
			Vote Registered Successfully!
			<a href="logout.jsp">Log Out</a>
		</c:when>
		<c:when test="${vb.count == 5}">
			You Have Already Voted!
		</c:when>
		<c:otherwise>
				Something Went Wrong!
		</c:otherwise>
	</c:choose>
	
		
</body>
</html>