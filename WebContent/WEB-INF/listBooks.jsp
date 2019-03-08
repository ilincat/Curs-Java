<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
  <table style="border: 1px solid;">
   <!-- iterate over the collection using forEach loop -->
   <c:forEach var="book" items="${books}">
       <!-- create an html table row -->
       <tr>
       <!-- create cells of row -->
       <td>${book.getTitle()}</td>
       <td>${book.getAuthorId()}</td>
       <td>${book.getYear()}</td>
       <!-- close row -->
       </tr>
       <!-- close the loop -->
   </c:forEach>
   <!-- close table -->
   </table>
</body>
</html>