<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<style type="text/css">

</style>
</head>
<body>
<jsp:include page="indexloginn.jsp"></jsp:include>




<div class="container">
<form:form action="login.htm" commandName="user" method="POST" class="form-signin">
      
        <h2 class="form-signin-heading">Please sign in</h2>
        
        
        <label for="username" class="sr-only">Username</label>
        <form:input path="username" size="30" class="form-control" placeholder="Username" /> <font color="red"><form:errors path="username"/></font>
        
        
        
        <label for="inputPassword" class="sr-only">Password</label>
        <form:password path="password" size="30" class="form-control" placeholder="Password" /> <font color="red"><form:errors path="password"/></font>
        
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form:form>

    </div>

</body>
</html>