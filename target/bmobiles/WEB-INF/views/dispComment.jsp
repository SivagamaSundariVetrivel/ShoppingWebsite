<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displaying Comment</title>
<style type="text/css">
li
{
list-style: none;
}
</style>
</head>
<body>
<%@include file="mainHead.jsp"%>
<c:forEach items="${cmtList}" var="cmt">
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-2">${cmt.userName}</div>
<div class="col-sm-8">${cmt.comment}</div> 
<div class="col-sm-1">

<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"> <span class="caret"></span></a>
            <ul class="dropdown-menu">
             <li><a href="editComment">edit</a></li>
             <li><a href="deleteComment">delete</a></li>
            </ul>
</li>
</div>
</div>
</div>
</c:forEach>
</body>
</html>