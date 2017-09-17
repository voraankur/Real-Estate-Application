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

</style>
<title></title>
</head>
<body>

<%-- <jsp:include page="indexloginn.jsp"></jsp:include> --%>

<c:choose>
<c:when test="${!empty sessionScope.user}">
<jsp:include page="indexlogout.jsp"></jsp:include>
</c:when>
<c:otherwise>
<jsp:include page="indexloginn.jsp"></jsp:include>
</c:otherwise>
</c:choose>


<div class="container">
    <h1>Search</h1>
    
    <form role="form" action="searchprop1.htm">
        <div class="row">
            <div class="form-group">
              	<input type="text" class="form-control input-lg" name="zipcode" placeholder="Enter Zipcode">
              	<input type="submit" id="search" value="Submit" class="btn btn-default" >
            </div>
            </div>

       
    </form>
</div>


<!-- <nav class="navbar navbar-default" role="navigation">
 <div class="container-fluid"> 
  <div class="navbar-header">
  	<a class="navbar-brand" href="index.htm">Zumba</a>
  </div>
  	<span>
    <a href="index.htm" type="button" class="btn btn-default navbar-btn">Home
      <span class="glyphicon glyphicon-home"></span>Home
    </a>
    <a href="adduser.htm" type="button" class="btn btn-default navbar-btn pull-right">Register </a>
    
      <span class="glyphicon glyphicon-shopping-cart"></span>
   </span>
  </div>
</nav>  -->

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


</body>
</html>