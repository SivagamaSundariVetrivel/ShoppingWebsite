<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product in Cart</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value='resources/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css"> 
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>
 <!-- angluarJS -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script> 
  <!-- <script src="<c:url value='/resources/angular-1.5.8/angular.min.js'/>"></script> -->
  <!-- <scrip src="/resources/bootstrap-3.3.6-dist/js/angular.min.js"></scrip> -->
<script>
var x=${cart};
var y=${cartId};
var z=${cartPrice};
angular.module('myApp',[]).controller('CarttController',function($scope)
		{       
			//console.log(v);
			$scope.cart=x;
			$scope.cartId=y;
			$scope.cartPrice=z;
		});
</script>
</head>
<body>
<%@include file="mainHead.jsp" %>
<h4>In Cart</h4>
<table class="table" ng-app="myApp" ng-controller="CarttController">
<thead>
<tr class="info">
<th>Image</th>
<th>Name</th>
<th>Quantity</th>
<th>Price per unit</th>
<th>Price</th>
<th></th><!-- <th></th> -->
</tr>
</thead>
<tbody>
<tr ng-repeat="pd in cart">
<td><img ng-src="{{pd.product.imgs}}" height="80px" width="50px"></td>
<td>{{pd.product.pname}} <%-- <form:hidden path="product" value="${pd.product}"/> --%> </td>
<td> {{pd.quantity}}<%-- <form:input class="form-control" path="quantity" id="quantity" name="quantity" value="${pd.quantity}"/> --%></td>
<td>Rs.{{pd.product.price}}</td>
<td>Rs.{{pd.product.price*pd.quantity}}</td>
<%-- <td><a type="submit" class="btn btn-warning" href="editItem?id=${pd.itemId}" commandName="item" >Update Quantity</a></td> --%>
<td><a commandName="item" href="deleteItem?id={{pd.itemId}}"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
<!-- <td></td> -->
<%-- </form:form> --%>
</tr>
</tbody>
<tr class="info">
<td colspan="4" align=right><strong>Total Price</strong></td>
<td>Rs.{{cartPrice}}</td>
<td></td>
<!-- <td></td> -->
<tr>
</table>
<div align="center">
<a href="product" class="btn btn-success" style="color:white">Continue Shopping</a>
<a href="orderNow?id={{cartId}}" class="btn btn-success" style="color:white">Order Now</a>
</div>
<div align="right">
</div>
</body>
</html>