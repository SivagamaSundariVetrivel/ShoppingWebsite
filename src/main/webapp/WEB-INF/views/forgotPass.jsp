<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
</head>
<body>
<%@include file="mainHead.jsp"%>
<br>
<br>
<br>
<center>
<h1>Forgot Password</h1>
<form method="post" action="./sendForgotEmail" for="form" class="form-group">
			<table border="0" width="50%">
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">To:</td> -->
					<td><input type="email" name="recipient" size="65" class="form-control" placeholder="Your emailId please.."/></td>
				</tr> 
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">Subject:</td> -->
					<td><input type="hidden" name="subject" size="65" value="Forgot Password..."/></td>
				</tr> 
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">Message:</td> -->
					<!-- <td><textarea  cols="1" rows="1" name="message" style="display:none;">
					
					</textarea> -->
					<td><br><p style="color:pink">${err}</p><br></td>
				</tr>		

<br>
<tr>
<td>
<center><input type="submit" value="Get PassWord" class="btn btn-info"/></center>
</td>
</tr>
</table>
</form>
</center>

</body>
</html>