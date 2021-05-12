<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/employee-management/entry" method="post">
		<input type="hidden" name="action" value="CreateEmployee">
		Name: <input type="text" name="name" min="3" required="required"><br>
		Email: <input type="email" name="email" required="required"><br>
		Department: <input type="text" name="department" required="required"><br><br>
		<input type="submit" value="Register Employee">
	</form>
</body>
</html>