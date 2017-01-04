<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>head with login</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%-- <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script> --%>
<style>
	/*   body{
      position: relative;
      background:url("<c:url value='/resources/images/pink.png'/>");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: right bottom;     
      
  } */
    .navbar-toggle .icon-bar {
    background-color:#5f9ea0;
    }
    .navbar-inverse{
      background-color:#4B0082;
      border-color:#4B0082;
     }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
     /* .dropdown-menu
     {
      background-color:#4B0082;
      border-color:#4B0082;
     } */
body {
    padding-top: 50px; 
}
	.navbar-inverse .navbar-fnt {
    color: 	#20B2AA;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" data-spy="affix" data-offset-top="197">
  <div id="cat" class="container-fluid">
   <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#web"><p class="title"><!-- b-mobiles --><img src="<c:url value='resources/images/sign.jpg'/>" height="25px" /></p></a>
   </div>
   <div>
   <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav" style="color:#20B2AA;">
     <li><a href="index">Home</a></li>
     <li><a href="info">About Us</a></li>
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> Category <span class="caret"></span></a>
            <ul class="dropdown-menu">
             <c:forEach items="${listCate}" var="category">
              <li><a commandName="cat" href="categoryPage?id=${category.cid}">${category.cname}</a></li>
              </c:forEach>
            </ul>
     </li>
     <li><a href="product">Product</a></li>
     <li><security:authorize access="hasRole('ROLE_ADMIN')">
     <a href="/bmobiles/adminHome">AdminHome</a>
     </security:authorize></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <form action="logout" id="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
    </form>
    <c:choose>
    <c:when test="${pageContext.request.userPrincipal.name!=null}">
    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${pageContext.request.userPrincipal.name}<span class="caret"></span></a>
            <ul class="dropdown-menu">
            	<!-- <li><a href="UserPage"></a>Profile</li> -->
            	<li><a href="CartPage">Cart</a></li>
              	<li><a href="OrderPage">Orders</a></li>
            </ul>
     </li>
    
    <li><a href="javascript:document.getElementById('logout').submit()"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
    </c:when>
    <c:when test="${pageContext.request.userPrincipal.name==null}">
     <li><a href="memberShip" ><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     <li><a data-toggle="modal" href="#login" data-target="#login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </c:when>
    </c:choose>
    </ul>
   </div>
  </div>
 </div>
</nav>

<!--login-->
<div id="login" class="modal fade" role="dialog">
  <div class="modal-dialog">
     <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h3 class="modal-title"><small>Login</small></h3>
      </div>
      <div class="modal-body">
        <form role="logform" action="<c:url value="/login" />" method="post">
         <div class="row">
          <div class="col-sm-12">
           <%-- <p style="color:red;">${noSuchUsr}</p> --%>
                 <c:if test="${not empty error}">
                <div class="error" style="color: red;">${error}</div><br>
                </c:if>
                <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('msg')}" var="err">
					  <div><span style="color:red">${err.text}</span></div>
					</c:forEach><br />
          <c:if test="${not empty msg }">
          <div class="msg" style="color: blue;">${msg}</div><br>
          </c:if>
          </div>
         </div>
         <div class="row">
           <div class="col-sm-4">
             <label for="userName">User Name:</label>
           </div>
           <div class="col-sm-4">
              <input type="text" class="form-control" name="userName" required>
           </div>
         </div><br>
         <div class="row">
            <div class="col-sm-4">    
              <label for="pwd">Password:</label>
            </div>
            <div class="col-sm-4">
               <input type="password" class="form-control" name="password" required>
            </div>
          </div><br>
       <a href="forgotPass">Forgot Password?</a>
      <br> 
     <!--  <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
      </div> -->
     <div class="modal-footer">
      <button type="submit" class="btn btn-success">LogIn</button>
      <a type="reset" href="#login" class="btn btn-danger">Reset</a>
     </div>
     </div>
      <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
     
    </form><br>
  </div>
</div>
</div>

</body>
</html>