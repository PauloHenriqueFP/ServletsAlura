<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		Update the employee : ${ employee.id }
		<form action="/employee-management/entry" method="post">
		<input type="hidden" name="action" value="UpdateEmployee">
		<input type="hidden" name="id" value="${ employee.id }">
		Name: <input type="text" name="name" min="3" required="required" value="${ employee.name } "><br>
		Email: <input type="email" name="email" required="required" value="${ employee.email } "><br>
		Department: <input type="text" name="department" required="required" value="${ employee.department } " ><br><br>
		<input type="submit" value="Update Employee">
	</form>
	</body>
</html>