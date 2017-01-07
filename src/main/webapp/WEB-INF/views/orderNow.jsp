<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product in Cart</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>
<title>Shipping Address</title>
<style>
form
{
background:white;
margin-top: 100px;
margin-right: 400px;
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
<form:form role="form" action="./payNow?id=${cartId}" commandName="ship" method="post" class="form-group">
<br>
<div class="row">
<div  class="col-sm-1">
</div>
<div  class="col-sm-4">
    <label for="address">Address Line1<span style="color:red">*</span>:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="addressLine1" name="adL1" required="true"/>
</div>
</div><br>
<div class="row">
<div  class="col-sm-1">
</div>
<div  class="col-sm-4">
    <label for="address">Address Line2<span style="color:red">*</span>:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="addressLine2" name="adL2" required="true"/>
</div>
  </div><br>
  <div class="row">
<div  class="col-sm-1">
</div>
<div  class="col-sm-4">
    <label for="address">Address Line3:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="addressLine3" name="adL3"/>
  </div>
  </div><br>
    <div class="row">
<div  class="col-sm-1">
</div>
  <div  class="col-sm-4">
    <label for="address">City<span style="color:red">*</span>:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="city" name="adL4" required="true" pattern="[A-Za-z].{3,}" title="Invalid city name.."/> 
  </div>
  </div><br>
    <div class="row">
<div  class="col-sm-1">
</div>
  <div  class="col-sm-4">
    <label for="address">State<span style="color:red">*</span>:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="state" name="adL5" required="true"  pattern="[A-Za-z].{3,}" title="Invalid state name.."/> 
  </div>
   </div><br>
    <div class="row">
<div  class="col-sm-1">
</div>
  <div  class="col-sm-4">
    <label for="country">Country<span style="color:red">*</span>:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="country" name="adL6" required="true"  pattern="[A-Za-z].{3,}" title="Invalid country name.."/> 
  </div>
   </div><br>
    <div class="row">
<div  class="col-sm-1">
</div>
  <div  class="col-sm-4">
    <label for="zipCode">PIN Code<span style="color:red">*</span>:</label>
</div>
<div  class="col-sm-6">
    <form:input type="text" class="form-control" path="zipCode" name="adL7" required="true"  pattern="[0-9].{6}" title="Invalid PIN Code.."/> 
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