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
  /* body{
      position: relative;
      background:url("<c:url value='//resources/images/product.jpg'/>");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: right bottom; 
      
  } */
  form
  {
  align:right;
  }
  </style>
<title>Add Product</title>
</head>
<body>
<%@include file="newHead.jsp" %>
<center>
<h2>Add a new Product</h2>
</center>
<form:form method="post" action="./saveProduct" commandName="prod"  enctype="multipart/form-data">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="name">Product Name:</label>
</div>
<div class="col-sm-5">
<form:input path="pname" class="form-control" placeholder="Product name"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="description">Product Description:</label>
</div>
<div class="col-sm-5">
<form:input path="pdescription" placeholder="Product description" class="form-control"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="supplier">Product's Supplier:</label>
</div>
<div class="col-sm-5">
<form:select path="sid" class="form-control">
<option value=" "> </option>
<c:forEach items="${sList}" var="sup">
<option value="${sup.sid}">${sup.sname}</option>
</c:forEach>
</form:select>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="category">Product's Category:</label>
</div>
<div class="col-sm-5">
<form:select path="cid" class="form-control">
<optiion value=" "> </optiion>
<c:forEach items="${cList}" var="cat">
<option value="${cat.cid}">${cat.cname}</option>
</c:forEach>
</form:select>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="stock">Product Stock:</label>
</div>
<div class="col-sm-5">
<form:input path="stock" placeholder="Stock" class="form-control"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="price">Product Price:</label>
</div>
<div class="col-sm-5">
<form:input path="price" placeholder="Product price" class="form-control"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="File">Product Image:</label>
</div>
<div class="col-sm-5">
<form:input type="file" path="file" placeholder="Product Image" name="file"/>
			<form:hidden path="imgs" value="${img}"/>
			<%-- <form:hidden path="fileName" value="${fileNam}"/> --%>
</div>
</div> 
<br> 
<center>
<button type="submit" class="btn btn-success" name="action" value="ADD">ADD</button>
<button type="reset" value="RESET" class="btn btn-danger" onclick="addProduct">RESET</button>
</center>
</form:form>
<br>
<!-- <a href="viewProduct">view products</a>   -->
<%@include file="viewProduct.jsp" %> 
<br>
</body>
</html>