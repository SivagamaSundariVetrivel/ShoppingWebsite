<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
<title>Shipping Address</title>
<style>
form
{
background:white;
margin-top: 100px;
margin-right: 300px;
margin-left: 500px;
}
body{
    background-image:url("<c:url value='/resources/images/postal-address-logo.png'/>");
    background-position:right bottom;
    background-repeat:no-repeat;
    background-attachment:fixed;
    }
</style>
</head>
<body>
<div id="signup" class="container-fluid">
<br>
<h2 class="page-header" style="color:grey;"><small>Shipping Address</small></h2>
<form:form role="form" action="order" commandName="shipping" method="post" class="form-group">
<br>
<div class="row">
<div  class="col-sm-1">
</div>
<div  class="col-sm-3">
    <label for="address">Address Line1:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="addressLine1"/>
</div>
</div><br>
<div class="row">
<div  class="col-sm-1">
</div>
<div  class="col-sm-3">
    <label for="address">Address Line2:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="addressLine2"/>
</div>
  </div><br>
  <div class="row">
<div  class="col-sm-1">
</div>
<div  class="col-sm-3">
    <label for="address">Address Line3:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="addressLine3"/>
  </div>
  <div  class="col-sm-3">
    <label for="address">City:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="city"/>
  </div>
  <div  class="col-sm-3">
    <label for="address">State:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="state"/>
  </div>
  <div  class="col-sm-3">
    <label for="country">Country:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="country"/>
  </div>
  <div  class="col-sm-3">
    <label for="zipCode">PIN Code:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="zipCode"/>
  </div>
</div><br>
<center>
  <input type="submit" class="btn btn-success" value="Submit"/>
  <input type="reset" class="btn btn-danger" value="Cancel"/>
</center><br>
<br>
</form:form>
</div>
</center>
</body>
</html>