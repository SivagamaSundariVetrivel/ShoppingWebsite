<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>Conform Page</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
   <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
   <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script> 
   <style>
    form
     {
	  background:white;
	  opacity:0.7;
	  margin-top: 100px;
	  margin-right: 300px;
 	  margin-left: 500px;
  	 }
 	 body{
     background-image:url("<c:url value='/resources/images/balloon_flight_plant_91681_1920x1080.jpg'/>");
     background-position:center;
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
   <h2 class="page-header" style="color:white;"><small>Conform Details</small></h2>
   <sf:form modelAttribute="userBean"> <%-- role="form" class="form-group" --%>
    <br>
	<div class="row">
 	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-3">
      <label for="usernName">User Name:</label>
	 </div>
	 <div  class="col-sm-6">
      <%-- <sf:label path="userName"  type="text" class="form-control" id="username" /> --%>${userBean.userName}
	 </div>
   	</div><br>
  	<div class="row">
	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-3">
      <label for="email">Email ID:</label>
	 </div>
	 <div  class="col-sm-6">
      <%-- <sf:label path="email"  type="email" class="form-control" id="email" /> --%>${userBean.email}
   	 </div>
	</div><br>
<%--   	<div class="row">
	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-3">
       <label for="pwd">Password:</label>
	 </div>
	 <div  class="col-sm-6">
     <sf:label path="password" type="password" class="form-control" id="pwd" />${userBean.password}
  	 </div>
	</div><br>
 --%>	<!-- <div class="row">
	 <div  class="col-sm-1">
	 </div>
 	 <div  class="col-sm-3">
      <label for="password">ReType Password:</label>
 	 </div>
	 <div  class="col-sm-6">
      <input type="password" class="form-control" id="reTypePassword">
      
	 </div>
	</div><br> -->
	<center ng-app="" ng-init="check={'false'}">
  	  <label><input type="checkbox" name="accept" ng-model="check"><strong> I accept</strong> to your <a href="#"><i>Terms and Conditions</i></a></label><br>
		<div class="alert alert-danger fade in" style="color:red; margin-left:10px;margin-right:10px;" ng-hide="check">
				Please accept the Terms and Conditions..
		</div>
  	  <button name="_eventId_edit" type="submit" value="Edit" class="btn btn-danger">Edit</button>
  	  <button name="_eventId_submit" type="submit" ng-show="check" value="Confirm Details" class="btn btn-success">Confirm Details</button>
   	</center><br>
	<br>
	</sf:form>
   </div>
  </center>

 </body>
</html>				
				