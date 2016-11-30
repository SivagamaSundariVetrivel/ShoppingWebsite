<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>

<title>Edit Supplier</title>
</head>
<body>
<%@include file="newHead.jsp" %>
<center>
<h2>Edit the Supplier ${sup.sname}</h2>
<form:form method="post" action="./updateSupplier" commandName="supply">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="ID">Supplier ID:</label>
</div>
<div class="col-sm-5">
<form:input path="sid" class="form-control" value="${sup.sid}" readonly="true"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="Name">Supplier Name:</label>
</div>
<div class="col-sm-5">
<form:input path="sname" class="form-control" value="${sup.sname}"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="Description">Supplier Description:</label>
</div>
<div class="col-sm-5">
<form:input path="sdescription" class="form-control" value="${sup.sdescription}"/>
</div>
</div>
<br>
<%-- <div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="product">Product supplied by Supplier:</label>
</div>
<div class="col-sm-5">
<form:input path="sid" class="form-control" value="${sup.sid}"/>
</div>
</div>
<br> --%>
<button type="submit" class="btn btn-success" value="EDIT">EDIT</button>
<button type="reset" value="RESET" class="btn btn-danger" onclick="editSupplier">RESET</button>
</form:form>
</center>
</body>
</html>