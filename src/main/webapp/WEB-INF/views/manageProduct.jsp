<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>  
  <style>
  body{
      position: relative;
      background:url("<c:url value='/resources/images/product.jpg'/>");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: right bottom; 
      
  }
  </style>
</head>
<body>
<%-- <%@include file="mainHead.jsp" %> --%>
<%@include file="mainHead.jsp" %>
<br>
<br>
<center>
<h3>Operations on product</h3>
<form>
<button class="btn"><a href="addProduct">Add Product</a></button><br><br>
<button class="btn"><a href="viewProdWidAngJS">View All Product</a></button><br><br>
<!-- <button class="btn"><a href="categoryProduct">View Product based on Category</a></button><br> -->
</form>
</center>
</body>
</html>