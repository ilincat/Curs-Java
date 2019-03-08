<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Welcome to my app!</h1>
<h2>Login</h2>
<form action="login" method="post">
	<input type="text" name="username" placeholder="Enter user name..">
	<input type="password" name="password" placeholder="Enter password..">
	<input type="submit" value="login">
</form>
<p>${invalid}</p>
<h2>Register</h2>
<form action="register" method="post">
	<input type="text" name="username" placeholder="Enter user name..">
	<input type="password" name="password" placeholder="Enter password..">
	<input type="submit" value="register">
</form>
<p>${duplicate}</p>
</body>
</html>