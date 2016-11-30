<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- bootstrap -->
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>
   <!-- angluarJS -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script> 
  <!-- <scrip src="/resources/bootstrap-3.3.6-dist/js/angular.min.js"></scrip> -->
<script>
var v=${pdata};
angular.module('myApp',[]).controller('ProductController',function($scope)
		{       
			//console.log(v);
			$scope.pList=v;
			
		});
</script>
 </head>
<body>
<%@include file="newHead.jsp" %>
<br>
<h4>Product to sale</h4>
 
<div class="container" ng-app="myApp" ng-controller="ProductController">
<div class="row">
<div class="col-sm-4">
<input type="text" class="form-control" placeholder="Search by name...." ng-model="sr.pname"/>
</div>
<div class="col-sm-2">
</div>
<div class="col-sm-4">
<input type="text" class="form-control" placeholder="Search by price...." ng-model="sr.price"/><br>
</div>
</div>
<table class="table">
<thead>
<tr class="info">
<th>ID</th>
<th>Name</th>
<th>Description</th>
<th>Supplier</th>
<th>Category</th>
<th>Price</th>
<!-- <th>Image</th> -->
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<tr ng-repeat="pd in pList|filter:sr"> 
<td>{{pd.pid}}</td>
<td>{{pd.pname}}</td>
<td>{{pd.pdescription}}</td>
<td>{{pd.sid}}</td>
<td>{{pd.cid}}</td>
<td>{{pd.price}}</td>
<%-- <td><img src="<c:out value="{{pd.imgs))"/>" height="100px" width="50px"/></td>   --%> 
<td><a href="editProduct?id={{pd.pid}}">edit</a></td>
<td><a href="deleteProduct?id={{pd.pid}}">delete</a></td>
</tr>
</tbody>
</div>

</table>
</body>
</html>