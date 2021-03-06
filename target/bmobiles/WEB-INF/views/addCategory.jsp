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
<title>Add Category</title>
</head>
<body>
<%@include file="newHead.jsp" %>
<center>
<h2>Add a new Category</h2>
</center>
<form:form method="post" action="./saveCategory" commandName="cat"  enctype="multipart/form-data">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="name">Category Name:</label>
</div>
<div class="col-sm-5">
<form:input path="cname" class="form-control" placeholder="Category name"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="description">Category Description:</label>
</div>
<div class="col-sm-5">
<form:input path="cdescription" placeholder="Category description" class="form-control"/>
</div>
</div>
<br>
<%-- <div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="product">Product of the category:</label>
</div>
<div class="col-sm-5">
<form:input path="pid" placeholder="Product's Category" class="form-control"/>
</div>
</div>
<br>
 --%><%-- <div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="stock">Category Stock:</label>
</div>
<div class="col-sm-5">
<form:input path="stock" placeholder="Stock" class="form-control"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="price">Category Price:</label>
</div>
<div class="col-sm-5">
<form:input path="price" placeholder="Category price" class="form-control"/>
</div>
</div>
<br> 
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="File">Category Image:</label>
</div>
<div class="col-sm-5">
<form:input type="file" path="file" placeholder="Category Image" name="file"/>
			<form:hidden path="imgpath" value="${img}"/>
</div>
</div> 
<br> --%>
<center>
<button type="submit" class="btn btn-success" name="action" value="ADD">ADD</button>
<button type="reset" value="RESET" class="btn btn-danger" onclick="addCategory">RESET</button>
</center>
</form:form>
<br>
<!-- <a href="viewCategory">view products</a>   -->
<%@include file="viewCategory.jsp" %> 
<br>
</body>
</html>