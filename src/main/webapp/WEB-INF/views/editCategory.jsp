<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>

<title>Edit Category</title>
</head>
<body>
<%@include file="mainHead.jsp" %>
<center>
<h2>Edit the Category ${cate.cname}</h2>
<form:form method="post" action="./updateCategory" commandName="cat" enctype="multipart/form-data">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="Id">Category ID:</label>
</div>
<div class="col-sm-5">
<form:input path="cid" class="form-control" value="${cate.cid}" readonly="true"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="Name">Category Name:</label>
</div>
<div class="col-sm-5">
<form:input path="cname" class="form-control" value="${cate.cname}"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="Description">Category Description:</label>
</div>
<div class="col-sm-5">
<form:input path="cdescription" class="form-control" value="${cate.cdescription}"/>
</div>
</div>
<br>
<%-- <div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="product">Product of the category:</label>
</div>
<div class="col-sm-5">
<form:input path="cid" class="form-control" value="${cate.cid}"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-4">
<label for="Price">Category Price:</label>
</div>
<div class="col-sm-5">
<form:input path="price" class="form-control" value="${cate.price}"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="File">Category Image:</label>
</div>
<div class="col-sm-5">
<form:input type="file" path="file" value="${cate.file}" name="file"/>
			<form:hidden path="imgs" value="${cate.imgpath}"/>
</div>
</div> 
<br>  --%>
<button type="submit" class="btn btn-success" value="EDIT">EDIT</button>
<button type="reset" value="RESET" class="btn btn-danger" onclick="editCategory">RESET</button>
</form:form>
</center>
</body>
</html>