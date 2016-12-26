<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="<c:url value='resources/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css"> 
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
<%@include file="mainHead.jsp"%>
<form:form method="post" action="./updateItem" commandName="item">
<div class="container">
<div class="row">
<div class="col-sm-5">
<img class="img-responsive" src="<c:url value="${itm.product.imgs}"/>" alt="${product.pname}" height="500"/>
</div>
<div class="col-sm-1"></div>
<div class="col-sm-5">
<%-- <c:set var="id" value="${itm.product.pid}"></c:set> --%>
<p name="id" >${itm.product.pid}</p><%-- value="${itm.product.pid}"/> --%>
<h1>${itm.product.pname}</h1>
<p>${itm.product.pdescription}</p>
<label>Price:</label><strong>Rs.${itm.product.price}</strong><br><br>
<form:hidden path="itemId" value="${itm.itemId}"/>
<span><label>Quantity:</label>
<form:input path="quantity" type="text" class="form-control" value="${itm.quantity}" name="quantity" id="quantity"/></span>
<br>
<div class="toRight">
<%-- <a href="payNow?total=${totalPrice}" class="btn btn-success" method="post">Buy</a> --%> 
<%-- <a class="btn btn-success" commandName="item" href="updateItem?id=${itm.itemId}"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Update Cart</a> --%>
<input type="submit" value="Update Item"/>
</div>
</div>
</div>
</div>
</form:form>
<%@include file="product.jsp" %>
</body>
</html>