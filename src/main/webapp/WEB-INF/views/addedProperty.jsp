<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Added Property</title>
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

<h1>Property Added Successfully by ${sessionScope.username}</h1>


</body>
</html>