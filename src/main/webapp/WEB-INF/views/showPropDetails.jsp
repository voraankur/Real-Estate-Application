<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Properties List</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.user==null}">
        <c:redirect url="/login.htm"/>
    </c:when>    
</c:choose>

<c:choose>
<c:when test="${!sessionScope.username}">
<jsp:include page="indexlogout.jsp"></jsp:include>
</c:when>
<c:otherwise>
<jsp:include page="indexloginn.jsp"></jsp:include>
</c:otherwise>
</c:choose>
<table border="1" cellpadding="5" cellspacing="5">
            <c:forEach var="prop" items="${searchProperties}">
            <tr>
                <td><b>Property Type</b></td>
                <td>${prop.propertyType}</td>
            </tr>
            <tr>
                <td><b>Number of Beds</b></td>
                <td>${prop.noOfBeds}</td>
            </tr>
            <tr>
                <td><b>Number of Baths</b></td>
                <td>${prop.noOfBathrooms}</td>
            </tr>
            <tr>
                <td><b>Area</b></td>
                <td>${prop.area}</td>
            </tr>
            
            <tr>
                <td><b>City</b></td>
                <td>${prop.address.city}</td>
            </tr>
            <tr>
                <td><b>Street</b></td>
                <td>${prop.address.streetName}</td>
            </tr>
            <tr>
                <td><b>Zipcode</b></td>
                <td>${prop.address.zipCode}</td>
            </tr>
            <tr> 
                <td><b>Status</b></td>
                <td>${prop.status}</td>
            </tr>
            <tr> 
                <td><b>Owner</b></td>
                <td>${prop.owner}</td>
            </tr>

            </c:forEach>
</table>
 

</body>
</html>