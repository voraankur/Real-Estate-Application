<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buyer Page</title>
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


<h1>Welcome ${sessionScope.username}</h1>

<form action="listprop.htm" method="POST">
<input type="submit" value="show properties">
</form>

<form action="searchprop.htm" method="POST">
<input type="text" name="zipCode"/>
<input type="submit" value="Search properties"/>
</form>

<c:choose>

<c:when test="${!empty searchProperties}">
<table border="1" cellpadding="5" cellspacing="5">
<tr>
                <td><b>Property Type</b></td>
                <td><b>Area</b></td>
                <td><b>Owner</b></td>
                <td><b>Zipcode</b></td>
                <td><b>Status</b></td>
                
            </tr>
            <c:forEach var="add" items="${searchProperties}">
                <tr>
                    <td>${add.property.propertyType}</td>
                    <td>${add.property.area}</td>
                    <td>${add.property.owner}</td>
                    <td>${add.zipCode}</td>
                    <td>${add.property.status}</td>
                    
                </tr>
            </c:forEach>
</table>
</c:when>
<%-- 
<c:when test="${!empty proplist}">
<h3>No records found for this pin. Search again </h3>
</c:when>
 --%>



</c:choose>

</body>
</html>