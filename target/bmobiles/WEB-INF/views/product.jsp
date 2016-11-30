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
	.mainbox div
	{
	display: inline;
    float: left;
	/* margin:2cm 4cm 3cm 4cm; */
	}
    .box
  {
  display: block;
  border: 1px solid   #a1a1a1 ;
    padding: 10px 40px;
    /* background: #dddddd; */
    width: 350px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    border-radius: 20px;
     margin-bottom: 20px;
     margin-left: 40px;
     width:300;
     height:600;
  }
  a
  {
  color:white;
  }
  </style>
</head>
<body>
<%@include file="mainHead.jsp"%>
<br><br>
<div class="mainbox">
<c:forEach items="${listProd}" var="p">
<div class="box">
<form commandName="prod">
<img src="<c:url value="${p.imgs}"/>" height="300px" width="200px"/>
<h4>${p.pname}</h4>
<%-- <p>${p.pdescription}</p> --%>
<p><strong>Rs. ${p.price}</strong></p>
<button class="btn btn-danger"><a commandName="prod" href="addToCart?id=${p.pid}">Add to Cart</a></button>
<button class="btn btn-success"><a href="viewThatProduct?id=${p.pid}">View</a> </button> 
</form>
</div>
</c:forEach>
</div>
<%-- <%@include file="footer.jsp" %> --%>
</body>
</html>