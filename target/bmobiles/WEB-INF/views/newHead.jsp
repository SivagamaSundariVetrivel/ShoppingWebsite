<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>head with logout</title>

<style type="text/css">
body {
    padding-top: 50px; 
}
    .navbar-toggle .icon-bar {
    background-color:#5f9ea0;
    }
    .navbar-inverse{
      background-color:#4B0082;
      border-color:#4B0082;
     }
.navbar-inverse .navbar-fnt {
    color: #FFFFFF;
}
   $(document).ready(function(){
   $('[data-toggle="tooltip"]').tooltip();
  });
  .navbar-default .navbar-toggle .icon-bar {
    background-color:#00BFFF;
}
</style>
</head>
<body>

 <nav class="navbar navbar-inverse navbar-fixed-top navbar-fnt" data-spy="affix" data-offset-top="197">
  <div class="container-fluid">
   <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
    </button>
     <a class="navbar-brand" href="#web"><p class="title"><!-- b-mobiles --><img src="<c:url value='resources/images/sign.jpg'/>" height="25px" /></p></a>
   </div>
   <div>
   <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
     <li><a href="homeout">Home</a></li>
     <li><a href="infoout">About Us</a></li>
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"> <!-- href="categoryPage"> -->Category <span class="caret"></span></a>
            <ul class="dropdown-menu">
             <c:forEach items="${listCate}" var="category">
              <li><a commandName="cat" href="categoryPage?id=${category.cid}">${category.cname}</a></li>
              </c:forEach>
            </ul>
     </li>
     <li><a href="product">Product</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><br><p style="color:#fff;">${user}</p></li>
    <li><br><p style="color:#fff;">${userBean.userName}</p></li>
     <li><a href="index"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li></ul>
   </div>
 </div>
 </div>
</nav><br>

</body>
</html>