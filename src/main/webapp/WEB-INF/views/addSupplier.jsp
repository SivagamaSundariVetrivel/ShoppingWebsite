<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.01 Transitional//EN" "http://www.w3.org/TR/html3/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>
  <style>
  form
  {
  align:right;
  }
  </style>
<title>Add Supplier</title>
</head>
<body>
<%@include file="mainHead.jsp" %>
<center>
<h2>Add a new Supplier</h2>
</center>
<form:form method="post" action="./saveSupplier" commandName="supply">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="name">Supplier Name:</label>
</div>
<div class="col-sm-5">
<form:input path="sname" class="form-control" placeholder="Supplier name" required="true"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="description">Supplier Description:</label>
</div>
<div class="col-sm-5">
<form:input path="sdescription" placeholder="Supplier description" class="form-control"/>
</div>
</div>
<br>
<%-- <div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="product">Product supplied by Supplier:</label>
</div>
<div class="col-sm-5">
<form:input path="pid" placeholder="Product supplied by Supplier" class="form-control"/>
</div>
</div>
<br> --%>

<center>
<button type="submit" class="btn btn-success" name="action" value="ADD">ADD</button>
<button type="reset" value="RESET" class="btn btn-danger" onclick="addSupplier">RESET</button>
</center>
</form:form>
<br>
<!-- <a href="viewSupplier">view supplyucts</a>   -->
<%@include file="viewSupplier.jsp" %> 
<br>
</body>
</html>