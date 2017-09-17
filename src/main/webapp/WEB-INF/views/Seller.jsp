<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Seller Page</title>
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.user}">
<jsp:include page="indexlogout.jsp"></jsp:include>
</c:when>
<c:otherwise>
<jsp:include page="indexloginn.jsp"></jsp:include>
</c:otherwise>
</c:choose>
<h1>Seller Page!!</h1>
<h1>Welcome ${sessionScope.username}</h1>


<div class="container">
  
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Add Property</button>
  <div id="demo" class="collapse">
    <form:form role="form" action="addproperty.htm" method="POST">
    <div class="form-group">
     <div class="col-xs-4">
      <label>Property Type</label>
      <select name="propertyType" class="form-control"  >
        <option>House</option>
        <option>Apartment</option>
        <option>Condos/co-ops</option>
        <option>Townhomes</option>
        <option>Manufactured</option>
      </select>
      </div>
      
      <div class="col-xs-4">
      <label>No of beds</label>
      <select name="noOfBeds" class="form-control" >
        <option>0</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
      </select>
      </div>
    
      <div class="col-xs-4">
      <label>No of Bathrooms</label>
      <select name="noOfBathrooms" class="form-control" >
        <option>1</option>
        <option>1.5</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
      </select>
      </div>
     
      <div class="col-xs-6">
      <label>Area</label>
      <input name="area" class="form-control" required/><font color="red"><form:errors path="area"/> </font>
      </div>
      
      <div class="col-xs-6">
      <label>Price</label>
      <input name="price" class="form-control" required/><font color="red"><form:errors path="price"/></font>
      </div>
      
      <div>
      <h4>Enter Property Address below</h4>
      </div>
      
      <div class="col-xs-4">
      <label>Street Name</label>
      <input name="streetName" class="form-control" required/><font color="red"><form:errors path="zipcode"/></font>
      </div>
      
      <div class="col-xs-4">
      <label>City</label>
      <input name="city" class="form-control" required/><font color="red"><form:errors path="zipcode"/></font>
      </div> 
      
      <div class="col-xs-4">
      <label>Zipcode</label>
      <input name="zipcode" class="form-control" required/><font color="red"><form:errors path="zipcode"/></font>
      </div>
      
    </div>
    <br/>
    <input type="submit" class="btn btn-success" value="Create Property" /> 
    <!-- <button type="button" class="btn btn-success" value="addProperty">Submit</button> -->
  </form:form>
  </div>
  
  <div>
  <h1></h1>
  </div>
  
  <form action="showownerprop.htm"  method="POST">
	<input type="submit" class="btn btn-info" value="show properties">
  </form>
  
  
<c:choose>

<c:when test="${!empty searchProperties}">
<table border="1" cellpadding="5" cellspacing="5">
<tr>
                <td><b>Property Type</b></td>
                <td><b>City</b></td>
                <td><b>Zipcode</b></td>
                <td><b>Status</b></td>
                <td><b>Buyer</b></td>
                <td><b>Action</b></td>
            </tr>
            <c:forEach var="prop" items="${searchProperties}">
                <tr>
                    <td>${prop.propertyType}</td>
                    <td>${prop.address.city}</td>
                    <td>${prop.address.zipCode}</td>
                    <td>${prop.status}</td>
                    <td>${prop.newOwner}</td>
                    <td><a href="#" data="${prop.propertyID}" class="assign">Make it Available</a></td>
                </tr>
            </c:forEach>
</table>
</c:when>
</c:choose>  
  


</div>

<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js">
</script>

<script type="text/javascript">
    $(document).ready(function() {

        $('.assign').click(function() {
            //e.preventDefault();
        	var record=$(this);
            var data = $(this).attr("data");
            $.ajax({
                url : 'markComplete1.htm',
                data : {
                    propertyID : data
                },
                success : function(res) {
                    if(res=="success"){
                    $(record).parent().prev().prev().text("Available");
                    $(record).parent().prev().text("");
                    /* $("#success").html("Task Marked Completed"); */
                    }
                }
            });
        });
    });
    

</script>



</body>
</html>