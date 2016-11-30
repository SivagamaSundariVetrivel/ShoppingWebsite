<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>AdminPage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>
  <style>
  body{
      position: relative;
      background:url("<c:url value='/resources/images/admin.jpg'/>");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: right bottom; 
      
  }
  p{
    line-height: 1.5;
    word-spacing: 5px;
   }
 
</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<%@include file="mainHead.jsp" %>
<br>

<div class="container-fluid">
 <div class="row">
<center>
<h1>Select your option admin</h1>
<form>
<div class="row">
<div class="col-sm-4">
<button class="form-control" ><a href="manageProduct">Manage Product</a></button>
</div>
<div class="col-sm-4">
<button class="form-control"><a href="manageCategory">Manage Category</a></button>
</div>
<div class="col-sm-4">
<button class="form-control"><a href="manageSupplier">Manage Supplier</a></button>
</div>
</form>
 </div>
<!--End of page-->
<%-- 
<div class="container-fluid">
<img style="margin:0px;" src="<c:url value='/resources/images/self.jpg'/>"/>
</div> --%>
<%-- <%@include file="footer.jsp" %> --%>
</center>
</div>
</body>
</html>
