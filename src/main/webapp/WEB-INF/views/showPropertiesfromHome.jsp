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
<c:when test="${!empty sessionScope.user}">
<jsp:include page="indexlogout.jsp"></jsp:include>
</c:when>
<c:otherwise>
<jsp:include page="indexloginn.jsp"></jsp:include>
</c:otherwise>
</c:choose>

<table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>Property Type</b></td>
                <td><b>Area</b></td>
                <td><b>Owner</b></td>
                <td><b>City</b></td>
                <td><b>Zipcode</b></td>
                <td><b>Status</b></td>
                <td><b></b></td>
                <td><b>Action</b></td>
            </tr>
            <c:forEach var="add" items="${properties}">
                <tr>
                <td>${add.property.propertyType}</td>
                    <td>${add.property.area}</td>
                    <td>${add.property.owner}</td>
                    <td>${add.city}</td>
                    <td>${add.zipCode}</td>
                    <td>${add.property.status}</td>
                
                    <td>
                   <%--  <c:url var="userView" value="userView.do" /> --%>
                    <a href="<c:out value='viewDetails.htm?propId=${add.property.propertyID}' />">
                    View Details</a>
                    <%-- <form action="viewDetails.htm" method="post">
                    <input type="submit" data="${prop.propertyID}" value="View more Details">
                    </form> --%>
					</td>
                    <c:choose>
                    <c:when test="${empty add.property.newOwner}">
                    <td><a href="#" data="${add.property.propertyID}" class="assign">Buy this property</a></td>
                    </c:when>
                    <c:otherwise>
                    <td>Sorry!! You are late</td>
                    </c:otherwise>
                    </c:choose>
                    
                </tr>
            </c:forEach>
        </table>
 
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
                url : 'markComplete.htm',
                data : {
                    propertyID : data
                },
                success : function(res) {
                    if(res=="success"){
                    $(record).parent().prev().text("Sold");
                    $(record).parent().text("");
                    $("#success").html("Task Marked Completed");
                    }
                }
            });
        });
    });
    

</script>

</body>
</html>