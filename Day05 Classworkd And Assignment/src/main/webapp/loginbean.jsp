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
	<jsp:setProperty name="loginb" property="*" />
	${loginb.authenticate()}
	<c:choose>
			<c:when test="${loginb.user.role == 'voter' }">
		
				 <c:redirect url="candlist.jsp"/>
			</c:when>
			<c:when test="${loginb.user.role == 'admin' }">
				 <c:redirect url="result.jsp"/>
			</c:when>			
		<c:otherwise>
			Login Failed! <a href="index.jsp">Try Again</a>
		</c:otherwise>
	</c:choose>	
			
</body>
</html>