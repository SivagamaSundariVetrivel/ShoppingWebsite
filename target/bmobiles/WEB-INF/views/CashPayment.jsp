<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>
<style>
form
{
background-color: #00bcd4;
margin-top: 100px;
margin-right: 300px;
margin-left: 500px;
}
span
{
font-size:small;
color:red;
}
label
{
color: white;
}
</style>
</head>
<body>
<div id="payNow" class="container-fluid">
<form action="ThankU" for="form" class="form-group" method="post">
<h3 class="page-header" style="color: white;">Payment Details</h3><br>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-3">
<label>Card User Name</label>
</div>
<div class="col-sm-5">
<input type="text" name="name" class="form-group block" required/><span>${errorNme}</span>
</div>
</div>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-3">
<label>Card Number</label>
</div>
<div class="col-sm-5">
<input type="text" name="cardNo" class="form-group block" required/><span>${errorNo}</span>
</div>
</div>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-3">
<label>Expiry Date</label>
</div>
<!-- <div  class="col-sm-1">
<input type="text" name="date" placeholder="dd" class="form-group" maxlength="2" size="2" required/></div>
<div  class="col-sm-1"></div> -->
<div  class="col-sm-1">
<input type="text" name="month" placeholder="mm" class="form-group" maxlength="2" size="2" required/></div>
<div  class="col-sm-1"></div>
<div  class="col-sm-1">
<input type="text" name="year" placeholder="yyyy" class="form-group" maxlength="4" size="4" required/>
</div>
<!-- </div>
<div class="row"> -->
<div class="col-sm-2"></div>
<!-- 
<div class="col-sm-1">
<label>CCV</label>
</div>
<div class="col-sm-1"></div> -->
<div class="col-sm-1">
<input type="text" name="ccv" placeholder="ccv" class="form-group" maxlength="3" size="3" required/>
</div>
</div>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-3">
<label>Pay Now</label>
</div>
<div  class="col-sm-1"></div>
<div  class="col-sm-1">
<label type="text" name="price" disabled="true" class="form-group">Rs.</label>
</div>
</div>
<input type="submit" value="Pay" class="btn btn-info btn-block"/>
</div>
</form>
</body>
</html>