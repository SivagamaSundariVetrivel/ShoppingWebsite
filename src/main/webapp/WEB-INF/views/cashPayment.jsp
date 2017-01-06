<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>">
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"> </script>
<style>
form
{
background-color: #00bcd4;
margin-top: 100px;
margin-right: 300px;
margin-left: 500px;
}
span
{
font-size:small;
color:red;
}
label
{
color: white;
}
</style>
</head>
<body>
<form method="post" action="./sendEmail?ship=${shippingDetials.shippingAddressId}" for="form" class="form-group">
			<table border="0" width="50%">
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">To:</td> -->
					<td><input type="hidden" value="${email}" name="recipient" size="65" /></td>
				</tr> 
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">Subject:</td> -->
					<td><input type="hidden" name="subject" size="65" value="Order Conformation..."/></td>
				</tr> 
				<tr>
					<!-- <td style="background-color:rgb(0, 0, 0);color:white">Message:</td> -->
					<td><textarea  cols="1" rows="1" name="message" style="display:none;">The products you have ordered are listed below:					
					<c:set var="totalPrice" value="0"></c:set><c:forEach var="pd" items="${cart}"><c:set var="totalPrice" value="${totalPrice+(pd.product.price*pd.quantity)}"></c:set>
Product Name: ${pd.product.pname}
Quantity: ${pd.quantity}
Price: Rs.${pd.product.price}

</c:forEach>Total Price:Rs.${totalPrice}

The above products are delivered to the address below:
${shippingDetials.addressLine1},
${shippingDetials.addressLine2},
${shippingDetials.addressLine3},
${shippingDetials.city}-${shippingDetials.zipCode}
${shippingDetials.state}
${shippingDetials.country}


Thank you for your purchase.
B-mobiles.
					</textarea></td>
				</tr> 
				
				<!-- <tr>
					<td colspan="3" align="center">
						<input type="submit" value="Place Order" />
					</td>
				</tr> -->
			</table>
<div id="payNow" class="container-fluid">
<%-- <form action="./validPay?order=${order}" for="form" class="form-group" method="post"> --%>
<h3 class="page-header" style="color: white;">Payment Details</h3><br>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-3">
<label>Card Holder Name</label>
</div>
<div class="col-sm-5">
<input type="text" name="name" class="form-group block" required/><%-- <span>${errorNme}</span> --%><br><h6 style="color:red;">${errorNme}</h6>
</div>
</div>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-3">
<label>Card Number</label>
</div>
<div class="col-sm-5">
<input type="text" name="cardNo" class="form-group block" required/><%-- <span>${errorNo}</span> --%><br><h6 style="color:red;">${errorNo}</h6>
</div>
</div>

<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-3">
<label>Expiry Date</label>
</div>
<!-- <div  class="col-sm-1">
<input type="text" name="date" placeholder="dd" class="form-group" maxlength="2" size="2" required/></div>
<div  class="col-sm-1"></div> -->
<div  class="col-sm-2">
<select name="month" class="form-control">
<option value="1">Jan</option>
<option value="2">Feb</option>
<option value="3">Mar</option>
<option value="4">Apr</option>
<option value="5">May</option>
<option value="6">Jun</option>
<option value="7">July</option>
<option value="8">Aug</option>
<option value="9">Sep</option>
<option value="10">Oct</option>
<option value="11">Nov</option>
<option value="12">Dec</option>
</select>
<!-- <input type="text" name="month" placeholder="mm" class="form-group" maxlength="2" size="2" required/> --></div>
<div  class="col-sm-1"></div>
<div  class="col-sm-2">
<!-- <input type="text" name="year" placeholder="yyyy" class="form-group" maxlength="4" size="4" required/> -->
<select name="year" class="form-control">
<c:forEach items="${yyyy}" var="year">
<option value="${year}">${year}</option>
</c:forEach>
</select>
</div>
<!-- </div>
<div class="row"> -->
<div class="col-sm-1"></div>
<!-- 
<div class="col-sm-1">
<label>CCV</label>
</div>
<div class="col-sm-1"></div> -->
<div class="col-sm-1">
<input type="text" name="ccv" placeholder="ccv" class="form-group" maxlength="3" size="3" required/>
</div>
</div>
<div class="col-sm-2"></div>
<h6 style="color:red;">${errorDate}</h6>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-3">
<label>Pay Now</label>
</div>
<div  class="col-sm-1"></div>
<div  class="col-sm-1">
<label type="text" name="price" disabled="true" class="form-group">Rs.${amount}</label>
</div>
</div>
<input type="submit" value="Pay" class="btn btn-info btn-block"/>
</div>
</form>
</body>
<%
   Cookie name = new Cookie("name",
 			  request.getParameter("name"));
   Cookie cardNo = new Cookie("cardNo",
			  request.getParameter("cardNo"));
   Cookie month = new Cookie("month",
			  request.getParameter("month"));
   Cookie year = new Cookie("year",
			  request.getParameter("year"));
   Cookie ccv = new Cookie("ccv",
			  request.getParameter("ccv"));

   name.setMaxAge(0); 
   cardNo.setMaxAge(0); 
   month.setMaxAge(0); 
   year.setMaxAge(0); 
   ccv.setMaxAge(0); 
   
   response.addCookie( name );
   response.addCookie( cardNo );
   response.addCookie( month );
   response.addCookie( year );
   response.addCookie( ccv );
%>
</html>