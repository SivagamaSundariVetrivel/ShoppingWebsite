<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
  <style>
  .container
  {
  margin-right:10px;
  margin-top:20px;
  }
  toRight
  {
  right:0px;
  }
  </style>
</head>
<body>
<%@include file="newHead.jsp"%>
<div class="container">
<div class="row">
<div class="col-sm-5">
<img class="img-responsive" src="<c:url value="${product.imgs}"/>" alt="${product.pname}" height="500"/>
</div>
<div class="col-sm-1"></div>
<div class="col-sm-5">
<h1>${product.pname}</h1>
<p>${product.pdescription}</p>
<label>Price:</label><strong>Rs.${product.price}</strong><br><br>
<div class="toRight">
<!-- <button class="btn btn-success">Buy</button> -->
<button class="btn btn-danger"><a commandName="prod" href="addToCart?id=${product.pid}">Add to Cart</a></button>
</div>
</div>
</div>
</div>
<%@include file="product.jsp" %>
</body>
</html>