<%@page import="com.sunbeam.pojos.Candidate"%>
<%@page import="java.util.List"%>
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
	<jsp:useBean id="cb" class="com.sunbeam.Beans.CandidateListBean"/>
	<h2>Candidate List</h2>
	<form method="post" action="vote.jsp">
	${cb.getCandidateList()} 
	<c:choose>
		<c:when test="${cb.list != null}">
			<c:forEach var="candidate" items="${cb.list}">
				<input type="radio" name="candidate" value= "${candidate.id}"  /> ${candidate.name} ( ${candidate.party} ) <br/>
			</c:forEach>
		</c:when>
		<c:otherwise>
				Something Went Wrong!
				<a href="index.jsp">Login Again</a>
			</c:otherwise>
	</c:choose>
	<input type="submit" value="Vote" >
	</form>
</body>
</html>