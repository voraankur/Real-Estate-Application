<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.navbar-header{
  margin-left:5px;
  margin-right:10px;
  padding-right:10px;
}

.form-control{
    width:94%;
    align:center;
    float:left;
  }
  
#search{
    height:45px;
  }
  
 /* Remove the navbar's default margin-bottom and rounded borders */ 
/*     .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
 */    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 90%; /* Set width to 100% */
      margin: auto;
      min-height:200px;
  }

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }

</style>
<title></title>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.user!=null}">
        <c:redirect url="/logout.htm"/>
    </c:when>    
</c:choose>


<nav class="navbar navbar-default" role="navigation">
 <div class="container-fluid"> 
  <div class="navbar-header">
  	<a class="navbar-brand" href="index.htm">Zumba</a>
  </div>
  	<span>
    <a href="index.htm" type="button" class="btn btn-default navbar-btn">Home
      <!-- <span class="glyphicon glyphicon-home"></span>Home -->
    </a>
    
    <a href="login.htm" type="button" class="btn btn-default navbar-btn pull-right">Login</a>
    <a href="adduser.htm" type="button" class="btn btn-default navbar-btn pull-right">Register </a>
    
      <!-- <span class="glyphicon glyphicon-shopping-cart"></span> -->
   </span>
  </div>
</nav> 

<div class="container">
    <h1>Search</h1>
    
    <form id="form" role="form" action="searchprop1.htm">
        <div class="row">
            <div class="form-group">
              	<input type="text" id="zip" class="form-control input-lg" name="zipcode" placeholder="Enter Zipcode" required>
              	<input type="submit" id="search" value="Submit" class="btn btn-default" >
            </div>
            </div>

       
    </form>
</div>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/real-estate-6.jpg" alt="Image">
        <div class="carousel-caption">
          <h3>Lone in the Island</h3>
          <p>$200K Onwards</p>
        </div>      
      </div>

      <div class="item">
        <img src="resources/images/real-estate-2.jpg" alt="Image">
        <div class="carousel-caption">
          <h3>Right around Pool</h3>
          <p>$150K Onwards</p>
        </div>      
      </div>
      
      <div class="item">
        <img src="resources/images/real-estate-3.jpg" alt="Image">
        <div class="carousel-caption">
          <h3>Beautiful Decor</h3>
          <p>$120K (On Bidding)</p>
        </div>      
      </div>
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  
<div class="container text-center">    
  <h3>Recently Added</h3><br>
  <div class="row">
    <div class="col-sm-4">
      <img src="resources/images/real-estate-7.jpg" class="img-responsive" style="width:100%" style="height:100" alt="Image">
      <p>In Boston</p>
    </div>
    <div class="col-sm-4"> 
      <img src="resources/images/real-estate-4.jpg" class="img-responsive" style="width:100%" style="height:100" alt="Image">
      <p>In NYC</p>    
    </div>
    <div class="col-sm-4"> 
      <img src="resources/images/real-estate-8.jpg" class="img-responsive" style="width:100%" style="height:100" alt="Image">
      <p>In Cali</p>    
    </div>
  </div>
</div><br>

<footer class="container-fluid text-center">
  <p>Copyright@WebToolsProject</p>
</footer>



<!-- <nav class="navbar navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Zumba</a>
    </div>
    <span>
    <ul class="nav navbar-nav">
      <li><a href="#">Home</a></li>
      <li><a href="#">Buyers</a></li>
      <li><a href="#">Sellers</a></li>
      <li><a href="#">Agents</a></li>
      
      <li><a href="login.htm">Login</a></li>
      
      <li><a href="adduser.htm">Register Here</a></li>
    </ul>
    </span>
    
  </div>
</nav>  -->

<script type="text/javascript">
$(document).ready(function () {

    function checkZip(value) {
        return (/(^\d{5}$)|(^\d{5}-\d{4}$)/).test(value);
    }

    $('#search').on('click', function (e) {
        e.preventDefault;
        var value = $('#zip').val();
        if (checkZip(value)) {
            alert('valid zip');
        } else {
            alert('invalid zip');
            
        }
    });

});
</script>


</body>
</html>