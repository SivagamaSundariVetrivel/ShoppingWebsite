<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
   <title>SignUp</title>
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
   <h2 class="page-header" style="color:white;">SignUp</h2>
   <sf:form modelAttribute="userBean" role="form"   class="form-group">
    <br>
    <%-- <c:if test="${not empty error}">
                <div class="error" style="color: red;">${error}</div>
    </c:if>
     <c:if test="${not empty msg }">
          <div class="msg">${msg}</div>
   	</c:if> --%>
	<div class="row">
 	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-3">
      <label for="usernName">User Name:</label>
	 </div>
	 <div  class="col-sm-6">
      <sf:input path="userName"  type="text" class="form-control" id="username"/>
						<!-- to display validation messages -->
					<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('userName')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
	 </div>
   	</div><br>
  	<div class="row">
	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-3">
      <label for="email">Email ID:</label>
	 </div>
	 <div  class="col-sm-6">
      <sf:input path="email" type="email" class="form-control" id="email"/>
      <!-- to display validation messages -->
					<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('email')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
   	 </div>
	</div><br>
  	<div class="row">
	 <div  class="col-sm-1">
	 </div>
	 <div  class="col-sm-3">
       <label for="pwd">Password:</label>
	 </div>
	 <div  class="col-sm-6">
     <sf:input path="password" type="password" class="form-control" id="pwd"/>
     <!-- to display validation messages -->
					<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
  	 </div>
	</div><br>
	<div class="row">
	 <div  class="col-sm-1">
	 </div>
 	 <div  class="col-sm-3">
      <label for="password">Conform Password:</label>
 	 </div>
	 <div  class="col-sm-6">
      <sf:input path="reTypePass" type="password" class="form-control" id="reTypePass"/>
       <!-- to display validation messages -->
					<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('reTypePass')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
      
	 </div>
	</div><br>
	<center>
  	  <!-- <label><input type="checkbox"><strong> I accept</strong></label><br> -->
  	  <button name="_eventId_submit" type="submit" value="SignUp" class="btn btn-success">SignUp</button>
  	  <button type="reset" class="btn btn-danger">Cancel</button>
	</center><br>
	<br>
	 <%-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/> --%>
	</sf:form>
   </div>
  </center>

 </body>
</html>