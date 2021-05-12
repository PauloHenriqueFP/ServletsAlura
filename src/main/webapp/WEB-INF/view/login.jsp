<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<form action="/employee-management/entry">
			<input type="hidden" name="action" value="Login">
			Login: <input type="text" name="login"><br>
			Password: <input type="password" name="password"><br>
			<br>
			<input type="submit" value="Sign In">
		</form>
	</body>
</html>