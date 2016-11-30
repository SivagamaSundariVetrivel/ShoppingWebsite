<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <title>Admin Login</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
   <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
   <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
   <style>
    form
     {
	  background:white;
	  opacity:0.7;
	  margin-top: 100px;
	  margin-right: 500px;
 	  margin-left: 250px;
  	 }
 	 body{
     background-image:url("<c:url value='/resources/images/IndiaTva8c9a3_baby-taking-selfie.jpg'/>");
     background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: right bottom;  
     }
     span
     {
     color:#00008B;
     font-weight:bold;
     }
	</style>
  </head>
  <body>
   <div id="signup" class="container-fluid">
   <br>
   <h2 class="page-header" style="color:black;">Admin Login</h2>
   <form role="form" action="./checkLogin" method="post" class="form-group"> 
    <br>
    <div class="row">
 	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-6">
      <label for="message" style="color:red;">${noSuchUsr}</label>
	 </div>
	</div>
	<br>
	<div class="row">
 	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-3">
      <label for="usernName">User Name:</label>
	 </div>
	 <div  class="col-sm-6">
      <input  type="text" class="form-control" id="username" name="username"/>
	</div>
   	</div><br>
   	
  	<div class="row">
	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-3">
       <label for="pwd">Password:</label>
	 </div>
	 <div  class="col-sm-6">
     <input name="password" type="password" class="form-control" id="pwd"/>
  	 </div>
	</div><br>
	<center>
  	  <!-- <label><input type="checkbox"><strong> I accept</strong></label><br> -->
  	  <button type="submit" value="Login" class="btn btn-success">Login</button>
  	  <button type="reset" class="btn btn-danger">Cancel</button>
	</center><br>
	<br>
	</form>
   </div>
  </center>

 </body>
</html>