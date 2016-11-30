<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <title>Mobile</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>
  <style>
   body{
      position: relative;
      background:url("<c:url value='//resources/images/aboutus.jpg'/>");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: right bottom; 
      
  }
    .navbar-toggle .icon-bar {
    background-color:#5f9ea0;
    }
   h2
   {
   color: white;
   text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px darkblue;
   } 
  p{
    line-height: 1.5;
    word-spacing: 5px;
   }
</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<%@include file="newHead.jsp" %>
<br>
<div class="container-fluid">
<br><br>

<div class="container-fluid">
<br><br>
 <div class="row">
	<div class="col-sm-1"></div>
  <div class="col-sm-5">  
  <h2>Why are we DOING this?</h2>
    <p style="text-indent: 50px;">
		We provide you info about all the mobiles latest in the market. It is easy to know all about your new mobile your <kbd>best-friend</kbd>.. 
</p>
  </div>
  <div class="col-sm-1"></div>
  <div class="col-sm-5">
  <h2>What do we DO?</h2>
	<p style="text-indent: 50px;">
		Mobiles have become really essential part of one's life. A person without mobile is a person without best-friend... We, <b style="font-family:Snap ITC;color:#00BFFF; font-size:15px;">bmoblies</b> give you an opporunity to find your partner..  
	</p>
  </div>
  <div class="col-sm-2">

 </div>
</div>
 <div class="row">
  <div class="col-sm-1"></div>
  <div class="col-sm-5">
   <h2>WHO are we?</h2>
	<p style="text-indent: 50px;">
		We are like the thread between the supplier and customer..(JUST like the thread in the background image)
	 We love to help you search a new mobile suits you.. The B in <b style="font-family:Snap ITC;color:#00BFFF; font-size:15px;">bmoblies</b> stands for bestfriend..
	</p>
  </div>
  <div class="col-sm-1"></div>
  <div class="col-sm-5">  
   <h2>Whats your NEED?</h2>
	<p style="text-indent: 50px;">
		You can search the mobile thats suits you based on
<ul>
<li>Brand</li>
<li>Camera</li>
<li>Memory Size</li>
<li>Colors</li>
<li>OS</li>
<li>Graphics</li>
<li>Sound</li>
</ul>
	</p>
  </div>
  <div class="col-sm-1">
  </div>
 </div>
<%--   <div class="row">
<div class="col-sm-1"></div>
  <div class="col-sm-10">  
   <h2>Comments</h2>
<form:form action="addComment" id="comment" for="comment" commandName="cmt">
<form:textarea path="comment" class="form-control block" placeholder="Please leave your comment here..."></form:textarea><br>
 <div class="row">n
<div class="col-sm-6"></div>
<div class="col-sm-4">
<form:input path="userName" placeholder="your user name.."/>
</div>
<div class="col-sm-2">
<a href="addComment"><button type="submit" class="btn btn-primary" style="align:right;">Comment</button></a>
</div>
</form:form>
</div>
 </div>
</div>
 --%></div>
<!--End of page-->
<br>
<br>
<br>
<%@include file="footer.jsp" %>
</body>
</html>  