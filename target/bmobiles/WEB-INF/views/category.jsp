<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Category</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css'/>" />
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js'/>"></script>
  <style>
   body {
      position: relative;
      background-color:black;
  } 
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      margin: auto;
  }
</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<%@include file="mainHead.jsp" %>
 <div class="item active">
 <div class="container">
  <div id="category" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="category" data-slide-to="0" class="active"></li>
      <li data-target="category" data-slide-to="1"></li>
      <li data-target="category" data-slide-to="2"></li>
      <li data-target="category" data-slide-to="3"></li>
      <li data-target="category" data-slide-to="4"></li>
      <li data-target="category" data-slide-to="5"></li>
      <li data-target="category" data-slide-to="6"></li>
    </ol>
       
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

<!--0-->       <div class="item active">
       <center>
        <img src="<c:url value='/resources/images/logos/samsung.jpg'/>" alt="SAMSUNG" width="600" height="450">
       </center>
        <div class="carousel-caption">
          <p>Mobiles which are user friendly with many laguage options..</p>
        </div>
      </div>

<!--1-->      <div class="item">
       <center>
        <img src="<c:url value='/resources/images/logos/xperia.jpg'/>" alt="SONY" width="600" height="450"/>
       </center>
        <div class="carousel-caption">
          <p>Mobiles with high resolution display..</p>
        </div>
      </div>
    
<!--2-->      <div class="item">
       <center>
        <img src="<c:url value='/resources/images/logos/apple.jpg'/>" alt="APPLE" width="400" height="450"/>
      </center>
      <div class="carousel-caption">
          <p>iPhones with high procrossor and many colors..</p>
        </div>
      </div>

<!--3-->      <div class="item">
       <center>
        <img src="<c:url value='/resources/images/logos/htc.png'/>" alt="htc" width="600" height="450"/>
       </center>
       <div class="carousel-caption">
       <p></p>
        </div>
      </div>

<!--4-->      <div class="item">
       <center>
        <img src="<c:url value='/resources/images/logos/moto.jpg'/>" alt="MOTOROLA" width="600" height="450"/>
       </center>
       <div class="carousel-caption">
          <h3>MOTOROLA</h3>
          <p></p>
        </div>
      </div>

<!--5-->      <div class="item">
       <center>
        <img src="<c:url value='/resources/images/logos/lenovo.jpg'/>" alt="LENOVO" width="600" height="450"/>
       </center>
        <div class="carousel-caption">
          <p></p>
        </div>
      </div>

<!--6-->       <div class="item">
       <center>
        <img src="<c:url value='/resources/images/logos/asus.jpg'/>" alt="ASUS" width="600" height="450"/>
       </center>
        <div class="carousel-caption">
          <p></p>
        </div>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#category" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="false"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#category" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
 </div>
</div>

<div id="cat" class="container-fluid">
<img src="<c:url value='/resources/images/cofeebean1.PNG'/>" style="opacity:0.05;float:right;margin=0px;" width="300" height="200"/>
</div>

<%@include file="footer.jsp" %>


</body>
</html>
  