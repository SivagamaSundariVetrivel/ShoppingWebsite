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

<title>Edit Product</title>
</head>
<body>
<%@include file="mainHead.jsp" %>
<center>
<h2>Edit the Product ${pd.pname}</h2>
<form:form method="post" action="./updateProduct" commandName="prod" enctype="multipart/form-data">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="Pid">Product ID:</label>
</div>
<div class="col-sm-5">
<form:input path="pid" class="form-control" value="${pd.pid}" readonly="true"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="Name">Product Name:</label>
</div>
<div class="col-sm-5">
<form:input path="pname" class="form-control" value="${pd.pname}"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="Description">Product Description:</label>
</div>
<div class="col-sm-5">
<form:input path="pdescription" class="form-control" value="${pd.pdescription}"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="supplier">Product's Supplier:</label>
</div>
<div class="col-sm-5">
<form:select path="sid" class="form-control">
<option value="${pd.sid}">
<c:forEach items="${sList}" var="sup">
<c:if test="${sup.sid}==${pd.sid}">${sup.sname}</c:if>
</c:forEach>
</option>
<c:forEach items="${sList}" var="sup">
<option value="${sup.sid}">${sup.sname}</option>
</c:forEach>
</form:select>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="category">Product's Category:</label>
</div>
<div class="col-sm-5">
<form:select path="cid" class="form-control">
<option value="${pd.cid}">
<c:forEach items="${cList}" var="cat">
<c:if test="${cat.cid}==${pd.cid}">${cat.cname}</c:if>
</c:forEach>
</option>
<c:forEach items="${listCate}" var="cat">
<option value="${cat.cid}">${cat.cname}</option>
</c:forEach>
</form:select>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="stock">Product Stock:</label>
</div>
<div class="col-sm-5">
<form:input path="stock" class="form-control" value="${pd.stock}"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="Price">Product Price:</label>
</div>
<div class="col-sm-5">
<form:input path="price" class="form-control" value="${pd.price}"/>
</div>
</div>
<br>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-3">
<label for="File">Product Image:</label>
</div>
<div class="col-sm-5">
<form:input type="file" path="file" value="${pd.imgs}" name="file"/><%-- ${pd.imgs} --%>
			<form:hidden path="imgs" value="${img}" alt="${pd.imgs}" name="path" /><!-- change img to pd.img -->
</div>
</div> 
<br> 
<button type="submit" class="btn btn-success" value="EDIT">EDIT</button>
<button type="reset" value="RESET" class="btn btn-danger" onclick="editProduct">RESET</button>
</form:form>
</center>
</body>
</html>