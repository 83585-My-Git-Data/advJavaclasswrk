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
	<jsp:useBean id="dc" class="com.sunbeam.Beans.DeleteCandidateBean"/>
	<jsp:setProperty name="dc" property="candidateId" param="id" />
	${dc.deleteCand()}
	<c:if test="${dc.count == 1}">
		<c:redirect url="result.jsp" />
	</c:if>
	
</body>
</html>