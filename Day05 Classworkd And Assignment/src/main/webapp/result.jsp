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
	<jsp:useBean id="rb" class="com.sunbeam.Beans.CandidateListBean" />
	${rb.getCandidateList()}
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="candidate" items="${rb.list}">
			<tr> 
				<td>${candidate.id}</td>
				<td>${candidate.name}</td>
				<td>${candidate.party}</td>
				<td>${candidate.votes}</td>
				<td><a href="editcand.jsp?id=${candidate.id}"><img src="images/edit.png" alt="edit" hieght="24" width="24"></a>
					<a href="deletecand.jsp?id=${candidate.id}"><img src="images/delete.png" alt="delete" hieght="24" width="24"></a>
				</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
</body>
</html>