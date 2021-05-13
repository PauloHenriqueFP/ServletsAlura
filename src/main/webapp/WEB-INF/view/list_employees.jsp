<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
	<body>
		User: ${ authenticatedUser.login } <br> <br>
	
		Employees:
		
		<c:if test="${not empty employees}">
			<ul style="list-style: none;">
			<c:forEach items="${employees}" var="employee">
				<li>Employee: ${ employee.id } 
				<a href="/employee-management/entry?action=UpdateEmployeeForm&id=${ employee.id }">edit</a> - 
				<a href="/employee-management/entry?action=RemoveEmployee&id=${ employee.id }" style="color: red"> remove </a></li>
				<br>
				<li>Name: ${ employee.name }</li>
				<li>Email: ${ employee.email }</li>
				<li>Department: ${ employee.department }</li>
				<hr>
			</c:forEach>
		</ul>
		</c:if>
		
		<c:if test="${empty employees}">
			No Employees found
		</c:if>
		
		
	</body>
</html>