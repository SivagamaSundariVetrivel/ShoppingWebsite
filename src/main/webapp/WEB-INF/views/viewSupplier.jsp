<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>

</head>
<body>
<%@include file="mainHead.jsp" %>
<h4>Suppliers</h4>
<table class="table">
<thead>
<tr class="info">
<th>ID</th>
<th>Name</th>
<th>Description</th>
<!-- <th>Product</th> -->
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<c:forEach var="sup" items="${listsupply}">
<tbody>
<tr>
<td>${sup.sid}</td>
<td>${sup.sname}</td>
<td>${sup.sdescription}</td>
<%-- <td>${sup.pid}</td> --%>
<td><a href="editSupplier?id=${sup.sid}">edit</a></td>
<td><a href="deleteSupplier?id=${sup.sid}">delete</a></td>
</tr>
</tbody>
</c:forEach>
</table>
</body>
</html>