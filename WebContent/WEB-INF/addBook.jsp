<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a book</title>
</head>
<body>
<h1>Add a book</h1>
<form action="newBook" method="post">
	<input type="text" name="title" placeholder="Enter title..">
	<input type="number" name="authorId" placeholder="Enter author Id..">
	<input type="number" name="year" placeholder="Enter year..">
	<input type="submit" value="Submit">
</form>
</body>
</html>