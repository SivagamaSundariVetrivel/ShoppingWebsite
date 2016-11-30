<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Mobile</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
  <style>
   /* .icon-bar {
    background-color:#5f9ea0;
    }
    .navbar-inverse{
      background-color: #1E90FF;
      border-color:	#1E90FF;
     }
.navbar-inverse .navbar-fnt {
    color: #FFFFFF;
} */
  body{
      position: relative;
      background:url("<c:url value='/resources/images/pink.png'/>");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-position: right bottom;     
      
  }
  p{
    line-height: 1.5;
    word-spacing: 5px;
   }
    $(document).ready(function(){
   $('[data-toggle="tooltip"]').tooltip();
  });
  

.div-button
{
    margin-left: 20px;
}
</style>
<!-- <script type="text/javascript">
    $(window).load(function(){
        $('#login').modal('show');
    });
</script> -->
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<%@include file="mainHead.jsp" %>

<div class="container-fluid">
 <div class="row">
  <div class="col-sm-1">
  </div>
  <div class="col-sm-7">  
  <div id="web">
    <h1 class="page-header text-right" style="font-family:Snap ITC;color:#00BFFF;">b-mobiles</h1>
    <p>Buy your new mobile from b-mobiles and make your BFF...</p>
    <p style="text-indent: 50px;">In this website, you able to find the phone that suit you. Please <strong>SignIn!</strong> to know about your new mobile phone.. This website provides you the information about all kind of phones.. You can order a prefect cell phone and get it at your doorstep on time..</p>
    <p>Please click create/open your account and click on <kbd>Category</kbd> on Navigation bar to shop with us...</p>  
  </div>
  </div>
<%--   <div class="col-sm-4 ">
   <div id="signup" class="container-fluid">
    <h1 class="page-header text-right"><small>SignUp</small></h1>
    <form role="form" class="form-group">
     <label for="lname">User Name:</label>
     <input type="text" class="form-control" id="lname" required>
     <label for="email">Email ID:</label>
     <input type="email" class="form-control" id="email" required>
     <label for="pwd" id="pass">Password:</label><br>
     <input type="password" class="form-control" id="pwd" required>
     <label for="password">ReType Password:</label>
     <input type="password" class="form-control" id="retype_pass" required><br>
     <label><input type="checkbox"><strong> I accept</strong></label>
     <br>
     <center>
       <button type="submit" onclick="check" class="btn btn-success">SignUp</button>
       <button type="reset" class="btn btn-danger">Cancel</button>
     </center>
   </form>
  </div> --%>
 </div>
<!--End of page-->

<div class="container-fluid">
<img style="margin:0px" src="<c:url value='/resources/images/self.jpg'/>"/>
</div>

<%@include file="footer.jsp" %>
</body>
</html>
  